package com.betinnapp.surveyservice.model.question;

import com.betinnapp.surveyservice.model.domain.QuestionType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class QuestionCreate {

    @NotNull
    @NotBlank
    private String text;

    @NotNull
    private QuestionType type;

    private UUID correctOptionId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public UUID getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(UUID correctOptionId) {
        this.correctOptionId = correctOptionId;
    }
}
