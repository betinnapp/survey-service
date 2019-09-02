package com.betinnapp.surveyservice.dao;

import com.betinnapp.surveyservice.model.domain.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyDAO extends CrudRepository<Survey, UUID> {
}
