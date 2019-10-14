package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.QuestionDAO;
import com.betinnapp.surveyservice.exception.EntityNotProcessedException;
import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.model.domain.QuestionAnswer;
import com.betinnapp.surveyservice.model.question.QuestionCreate;
import com.betinnapp.surveyservice.model.survey.SurveyQuestionAnswer;
import com.betinnapp.surveyservice.model.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService extends AbstractCrudService<Question> {

    private final UserService userService;
    private final QuestionAnswerService questionAnswerService;

    public QuestionService(QuestionDAO questionDAO, QuestionAnswerService questionAnswerService, UserService userService) {
        super(Question.class, questionDAO);

        this.questionAnswerService = questionAnswerService;
        this.userService = userService;
    }

    public Question create(UUID surveyId, QuestionCreate questionCreate) {
        Question question = new Question();

        question.setSurveyId(surveyId);
        question.setText(questionCreate.getText());
        question.setType(questionCreate.getType());

        return super.create(question);
    }

    public Question edit(String authorizationToken, Question resource) {
        Question question = this.getById(resource.getId(), authorizationToken);

        Optional
                .ofNullable(resource.getText())
                .ifPresent(question::setText);

        Optional
                .ofNullable(resource.getType())
                .ifPresent(question::setType);

        Optional
                .ofNullable(resource.getCorrectOptionId())
                .ifPresent(question::setCorrectOptionId);

        return super.edit(question);
    }

    public Question getById(UUID id, String authorizationToken) {
        Question question = super.getById(id);
        Optional<User> userInfo = userService.getUserByToken(authorizationToken);

        userInfo
                .map(User::getId)
                .flatMap(userId -> questionAnswerService.getAnsweredOption(userId, id))
                .ifPresent(question::setAnsweredOptionId);

        return question;
    }

    @Transactional
    public void answerQuestion(String authorizationToken, UUID questionId, SurveyQuestionAnswer surveyQuestionAnswer) {
        Optional<User> user = userService.getUserByToken(authorizationToken);

        if (user.isPresent()) {
            UUID userId = user.get().getId();
            UUID optionId = surveyQuestionAnswer.getOptionId();

            try {
                questionAnswerService.create(userId, questionId, optionId);
            }
            catch (RuntimeException e) {
                throw new EntityNotProcessedException(QuestionAnswer.class);
            }
        }
        else {
            throw new IllegalArgumentException("User does not exist");
        }
    }
}
