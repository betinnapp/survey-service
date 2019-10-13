package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.SurveyDAO;
import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.model.domain.Survey;
import com.betinnapp.surveyservice.model.question.QuestionCreate;
import com.betinnapp.surveyservice.model.survey.SurveyCreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class SurveyService extends AbstractCrudService<Survey> {

    private final QuestionService questionService;

    public SurveyService(SurveyDAO surveyDAO, QuestionService questionService) {
        super(Survey.class, surveyDAO);

        this.questionService = questionService;
    }

    public Survey create(SurveyCreate surveyCreate) {
        Survey survey = new Survey();
        survey.setName(surveyCreate.getName());
        survey.setDescription(surveyCreate.getDescription());

        return super.create(survey);
    }

    @Transactional
    public Survey addQuestion(UUID surveyId, QuestionCreate questionCreate) {
        Survey survey = getById(surveyId);
        Question question = questionService.create(surveyId, questionCreate);

        Set<Question> questions = survey.getQuestions();
        questions.add(question);

        return survey;
    }
}
