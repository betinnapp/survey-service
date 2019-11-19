package com.betinnapp.surveyservice.controller;

import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.model.survey.SurveyQuestionAnswer;
import com.betinnapp.surveyservice.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public class QuestionsController {

    private QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Question getById(@RequestHeader("authorization") String authorization, @PathVariable UUID id) {
        return questionService.getById(id, authorization);
    }

    @PutMapping
    public Question edit(@RequestHeader("authorization") String authorization, @RequestBody Question question) {
        return questionService.edit(authorization, question);
    }

    @PostMapping("/{id}:answer")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void answerSurveyQuestion(@RequestHeader("authorization") String authorization,
                                     @PathVariable UUID id,
                                     @RequestBody SurveyQuestionAnswer surveyQuestionAnswer) {

        questionService.answerQuestion(authorization, id, surveyQuestionAnswer);
    }
}
