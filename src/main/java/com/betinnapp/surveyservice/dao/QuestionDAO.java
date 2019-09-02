package com.betinnapp.surveyservice.dao;

import com.betinnapp.surveyservice.model.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionDAO extends CrudRepository<Question, UUID> {
}
