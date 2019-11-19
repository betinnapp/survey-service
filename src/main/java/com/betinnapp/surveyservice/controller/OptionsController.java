package com.betinnapp.surveyservice.controller;

import com.betinnapp.surveyservice.model.domain.Option;
import com.betinnapp.surveyservice.model.option.OptionCreate;
import com.betinnapp.surveyservice.service.OptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/options")
public class OptionsController {

    private final OptionService optionService;

    public OptionsController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public List<Option> getAll() {
        return optionService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Option getById(@PathVariable UUID id) {
        return optionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Option create(@Valid @RequestBody OptionCreate surveyCreate) {
        return optionService.create(surveyCreate);
    }
}
