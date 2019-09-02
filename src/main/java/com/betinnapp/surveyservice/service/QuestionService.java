package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.QuestionDAO;
import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.model.question.QuestionCreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class QuestionService extends AbstractCrudService<Question> {

    private final QuestionDAO questionDAO;

    public QuestionService(QuestionDAO questionDAO) {
        super(Question.class, questionDAO);
        this.questionDAO = questionDAO;
    }

    @Transactional
    public Question create(UUID surveyId, QuestionCreate questionCreate) {
        Question question = new Question();
        question.setText(questionCreate.getText());
        question.setType(questionCreate.getType());
        question.setSurveyId(surveyId);

        return questionDAO.save(question);
    }
}
