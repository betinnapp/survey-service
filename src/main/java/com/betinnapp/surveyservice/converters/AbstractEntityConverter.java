package com.betinnapp.surveyservice.converters;

public abstract class AbstractEntityConverter<T> {

    abstract public <U> T toEntity(U object);

}
