package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.QuestionAnswerDAO;
import com.betinnapp.surveyservice.model.domain.QuestionAnswer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionAnswerService extends AbstractCrudService<QuestionAnswer> {

    private final QuestionAnswerDAO questionAnswerDAO;

    public QuestionAnswerService(QuestionAnswerDAO questionAnswerDAO) {
        super(QuestionAnswer.class, questionAnswerDAO);
        this.questionAnswerDAO = questionAnswerDAO;
    }

    public QuestionAnswer create(UUID userId, UUID questionId, UUID optionId) {
        QuestionAnswer questionAnswer = new QuestionAnswer();

        questionAnswer.setUserId(userId);
        questionAnswer.setOptionId(optionId);
        questionAnswer.setQuestionId(questionId);

        return super.create(questionAnswer);
    }

    public Optional<UUID> getAnsweredOption(UUID userId, UUID questionId) {
        return questionAnswerDAO
                .findByUserIdAndQuestionId(userId, questionId)
                .map(QuestionAnswer::getOptionId);
    }
}
