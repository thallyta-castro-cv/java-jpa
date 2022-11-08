package com.thallyta.relationship.models.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private Class<E> classDAO;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("java-jpa");
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classDAO) {
        this.classDAO = classDAO;
        entityManager = entityManagerFactory.createEntityManager();
    }

    public DAO<E> openTransaction() {
        entityManager.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        entityManager.getTransaction().commit();
        return this;
    }

    public DAO<E> include(E entity) {
        entityManager.persist(entity);
        return this;
    }

    public DAO<E> includeAtomic(E entity) {
        return this.openTransaction().include(entity).closeTransaction();
    }

    public E getById(Object id) {
        return entityManager.find(classDAO, id);
    }

    public List<E> consult(String nameConsult, Object... params) {
        TypedQuery<E> query = entityManager.createNamedQuery(nameConsult, classDAO);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public E consultOne(String nameConsult, Object... params) {
        List<E> list = consult(nameConsult, params);
        return list.isEmpty() ? null : list.get(0);
    }

    public void close() {
        entityManager.close();
    }
}
