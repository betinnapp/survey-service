package com.betinnapp.surveyservice.model.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", length = 16, unique = true, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "text", nullable = false)
    private String text;

    @Type(type = "pg-uuid")
    @Column(name = "survey_id", nullable = false, updatable = false)
    private UUID surveyId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false, length = 40)
    private QuestionType type;

    @OneToMany(mappedBy = "questionId", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<Option> options;

    public UUID getId() {
        return id;
    }

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

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public UUID getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(UUID surveyId) {
        this.surveyId = surveyId;
    }
}
