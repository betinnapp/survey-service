package com.betinnapp.surveyservice.controller;

import com.betinnapp.surveyservice.model.domain.Question;
import com.betinnapp.surveyservice.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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
    public Question getById(@PathVariable UUID id) {
        return questionService.getById(id);
    }
}
