package com.betinnapp.surveyservice.model.option;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OptionCreate {

    @NotNull
    @NotBlank
    private String text;

    @NotNull
    @Min(value = 0)
    private Integer score;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
