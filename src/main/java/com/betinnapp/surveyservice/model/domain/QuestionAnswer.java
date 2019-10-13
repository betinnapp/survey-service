package com.betinnapp.surveyservice.model.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "question_answers")
public class QuestionAnswer {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", length = 16, unique = true, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Type(type = "pg-uuid")
    @Column(name = "question_id", updatable = false)
    private UUID questionId;

    @Type(type = "pg-uuid")
    @Column(name = "option_id", updatable = false)
    private UUID optionId;

    @Type(type = "pg-uuid")
    @Column(name = "user_id", updatable = false)
    private UUID userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public UUID getOptionId() {
        return optionId;
    }

    public void setOptionId(UUID optionId) {
        this.optionId = optionId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
