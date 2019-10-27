package com.betinnapp.surveyservice.model.survey;

import java.util.UUID;

public class SurveyQuestionAnswer {

    private UUID optionId;

    public UUID getOptionId() {
        return optionId;
    }

    public void setOptionId(UUID optionId) {
        this.optionId = optionId;
    }
}
