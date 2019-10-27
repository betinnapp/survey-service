package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.OptionDAO;
import com.betinnapp.surveyservice.model.domain.Option;
import com.betinnapp.surveyservice.model.option.OptionCreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionService extends AbstractCrudService<Option> {

    public OptionService(OptionDAO optionDAO) {
        super(Option.class, optionDAO);
    }

    public Option create(OptionCreate optionCreate) {
        Option option = new Option();
        option.setText(optionCreate.getText());
        option.setScore(optionCreate.getScore());
        option.setQuestionId(optionCreate.getQuestionId());

        return super.create(option);
    }
}
