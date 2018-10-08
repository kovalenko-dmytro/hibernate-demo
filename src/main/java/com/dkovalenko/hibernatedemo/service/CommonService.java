package com.dkovalenko.hibernatedemo.service;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;

import java.util.List;


public interface CommonService<E extends AbstractEntity> {

    List<E> find();
    E find(long id);
    E save(E e);
    E update(E e);
    void delete(long id);
}
