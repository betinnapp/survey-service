package com.betinnapp.surveyservice.controller;

import com.betinnapp.surveyservice.model.domain.Survey;
import com.betinnapp.surveyservice.model.question.QuestionCreate;
import com.betinnapp.surveyservice.model.survey.SurveyCreate;
import com.betinnapp.surveyservice.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/surveys")
public class SurveysController {

    private final SurveyService surveyService;

    public SurveysController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public List<Survey> getAll() {
        return surveyService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Survey getById(@PathVariable UUID id) {
        return surveyService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Survey create(@Valid @RequestBody SurveyCreate surveyCreate) {
        return surveyService.create(surveyCreate);
    }

    @PostMapping("/{id}/questions/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Survey addQuestion(@PathVariable UUID id, @Valid @RequestBody QuestionCreate questionCreate) {
        return surveyService.addQuestion(id, questionCreate);
    }
}
