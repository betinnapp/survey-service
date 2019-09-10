package com.betinnapp.surveyservice.configuration;

import com.betinnapp.surveyservice.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdviceExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFoundException(EntityNotFoundException e, HttpServletResponse response) throws IOException {
        LOGGER.debug("Entity {} with id {} not found. Details {}", e.getType(), e.getEntityId(), e);
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public void handleRuntimeException(Exception e, HttpServletResponse response) throws IOException {
        LOGGER.error("Unhandled exception thrown", e);
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
