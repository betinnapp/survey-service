package com.betinnapp.surveyservice.model.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "option")
public class Option {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", length = 16, unique = true, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Type(type = "pg-uuid")
    @Column(name = "question_id", nullable = false, updatable = false)
    private UUID questionId;

    public UUID getId() {
        return id;
    }

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

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }
}
