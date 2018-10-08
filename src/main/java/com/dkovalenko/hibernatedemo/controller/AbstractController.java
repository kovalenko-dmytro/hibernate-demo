package com.dkovalenko.hibernatedemo.controller;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import com.dkovalenko.hibernatedemo.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    protected final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }
}
