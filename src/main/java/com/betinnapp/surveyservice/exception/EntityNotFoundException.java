package com.betinnapp.surveyservice.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

    private String type;

    private UUID entityId;

    public EntityNotFoundException(Class<?> type, UUID entityId) {
        this.type = type.getTypeName();
        this.entityId = entityId;
    }

    public String getType() {
        return type;
    }

    public UUID getEntityId() {
        return entityId;
    }
}
