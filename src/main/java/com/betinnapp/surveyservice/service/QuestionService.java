package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.clients.UserServiceClient;
import com.betinnapp.surveyservice.dao.QuestionDAO;
import com.betinnapp.surveyservice.exception.EntityNotProcessedException;
import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.model.domain.QuestionAnswer;
import com.betinnapp.surveyservice.model.question.QuestionCreate;
import com.betinnapp.surveyservice.model.survey.SurveyQuestionAnswer;
import com.betinnapp.surveyservice.model.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class QuestionService extends AbstractCrudService<Question> {

    private final UserServiceClient userServiceClient;
    private final QuestionAnswerService questionAnswerService;

    public QuestionService(QuestionDAO questionDAO,
                           QuestionAnswerService questionAnswerService,
                           UserServiceClient userServiceClient) {

        super(Question.class, questionDAO);

        this.questionAnswerService = questionAnswerService;
        this.userServiceClient = userServiceClient;
    }

    public Question create(UUID surveyId, QuestionCreate questionCreate) {
        Question question = new Question();

        question.setSurveyId(surveyId);
        question.setText(questionCreate.getText());
        question.setType(questionCreate.getType());

        return super.create(question);
    }

    @Override
    public Question edit(Question resource) {
        Question question = getById(resource.getId());

        question.setText(resource.getText());
        question.setType(resource.getType());
        question.setAnsweredOptionId(resource.getAnsweredOptionId());

        return super.edit(resource);
    }

    public Question getById(UUID id, String authorizationToken) {
        User userInfo = userServiceClient.getUserInfo(authorizationToken);
        UUID answeredOptionId = questionAnswerService.getAnsweredOption(userInfo.getId(), id);

        Question question = super.getById(id);
        question.setAnsweredOptionId(answeredOptionId);

        return question;
    }

    @Transactional
    public void answerQuestion(String authorizationToken, UUID questionId, SurveyQuestionAnswer surveyQuestionAnswer) {
        try {
            User userInfo = userServiceClient.getUserInfo(authorizationToken);

            UUID userId = userInfo.getId();
            UUID optionId = surveyQuestionAnswer.getOptionId();

            questionAnswerService.create(userId, questionId, optionId);
        }
        catch (RuntimeException e) {
            throw new EntityNotProcessedException(QuestionAnswer.class);
        }
    }
}
