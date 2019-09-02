package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.dao.OptionDAO;
import com.betinnapp.surveyservice.model.domain.Option;
import com.betinnapp.surveyservice.model.option.OptionCreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionService extends AbstractCrudService<Option> {

    private final OptionDAO optionDAO;

    public OptionService(OptionDAO optionDAO) {
        super(Option.class, optionDAO);
        this.optionDAO = optionDAO;
    }

    @Transactional
    public Option create(OptionCreate optionCreate) {
        Option option = new Option();
        option.setText(optionCreate.getText());
        option.setScore(optionCreate.getScore());

        return optionDAO.save(option);
    }
}
