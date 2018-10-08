package com.dkovalenko.hibernatedemo.dao;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
public abstract class AbstractDAO<E extends AbstractEntity> implements CommonDAO<E> {

    @Autowired
    protected EntityManager entityManager;
    private E e;

    public AbstractDAO(E e) {
        this.e = e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> find() {

        return entityManager.createQuery("SELECT e FROM " + getClassName() + " e")
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E find(long id) {

        return (E)entityManager.createQuery("SELECT e FROM " + getClassName() + " e WHERE id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public E save(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public abstract E update(E e);

    @Override
    public void delete(long id) {

        entityManager.remove(find(id));

    }

    private String getClassName() {

        Class<? extends AbstractEntity> eClass = e.getClass();

        return eClass.getSimpleName();
    }
}
