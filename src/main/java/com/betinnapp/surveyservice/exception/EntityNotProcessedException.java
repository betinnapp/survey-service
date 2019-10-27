package com.betinnapp.surveyservice.exception;

import java.util.UUID;

public class EntityNotProcessedException extends RuntimeException {

    private String type;

    private UUID entityId;

    public EntityNotProcessedException(Class<?> type, UUID entityId) {
        this.type = type.getTypeName();
        this.entityId = entityId;
    }

    public EntityNotProcessedException(Class<?> type) {
        this.type = type.getTypeName();
    }

    public String getType() {
        return type;
    }

    public UUID getEntityId() {
        return entityId;
    }
}
