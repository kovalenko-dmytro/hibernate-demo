package com.dkovalenko.hibernatedemo.service;

import com.dkovalenko.hibernatedemo.dao.AbstractDAO;
import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public  abstract class AbstractService<E extends AbstractEntity, R extends AbstractDAO<E>>
        implements CommonService<E> {

    private final R repository;

    @Autowired
    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> find() {
        return repository.find();
    }

    @Override
    public E find(long id) {
        return repository.find(id);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
