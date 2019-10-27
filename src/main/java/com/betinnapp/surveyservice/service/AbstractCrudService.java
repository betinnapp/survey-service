package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.exception.EntityNotFoundException;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractCrudService<T> {

    private final Class<T> entityType;
    private final CrudRepository<T, UUID> crudRepository;

    public AbstractCrudService(Class<T> entityType, CrudRepository<T, UUID> crudRepository) {
        this.entityType = entityType;
        this.crudRepository = crudRepository;
    }

    public List<T> getAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public T getById(UUID id) {
        return crudRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(entityType, id));
    }

    @Transactional
    public T create(T resource) {
        return crudRepository.save(resource);
    }

    @Transactional
    public T edit(T resource) {
        return crudRepository.save(resource);
    }
}
