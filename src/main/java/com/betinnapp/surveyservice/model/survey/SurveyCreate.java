package com.betinnapp.surveyservice.model.survey;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SurveyCreate {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
