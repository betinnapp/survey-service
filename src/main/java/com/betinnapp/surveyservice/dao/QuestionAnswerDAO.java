package com.betinnapp.surveyservice.dao;

import com.betinnapp.surveyservice.model.domain.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionAnswerDAO extends CrudRepository<QuestionAnswer, UUID> {

    Optional<QuestionAnswer> findByUserIdAndQuestionId(@Param("userId") UUID userId,
                                                       @Param("questionId") UUID questionId);
}