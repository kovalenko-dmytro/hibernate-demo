package com.dkovalenko.hibernatedemo.dao;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;

import java.util.List;


public interface CommonDAO<E extends AbstractEntity> {

    List<E> find();
    E find(long id);
    E save(E e);
    E update(E e);
    void delete(long id);
}
