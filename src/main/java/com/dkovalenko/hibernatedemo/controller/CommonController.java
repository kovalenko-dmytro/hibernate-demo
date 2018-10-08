package com.dkovalenko.hibernatedemo.controller;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import org.springframework.web.servlet.ModelAndView;


public interface CommonController<E extends AbstractEntity> {

    ModelAndView find();

    ModelAndView find(long id);

    ModelAndView create();

    ModelAndView create(E e);

    ModelAndView update(long id);

    ModelAndView update(long  id, E e);

    ModelAndView delete(long id);
}
