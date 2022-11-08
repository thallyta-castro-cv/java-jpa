package com.thallyta.basic.models.daos;

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

    public List<E> getAll() {
        return this.getAll(10, 0);
    }

    public List<E> getAll(int amount, int displacement) {
        if (classDAO == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from " + classDAO.getName() + " e";
        TypedQuery<E> query = entityManager.createQuery(jpql, classDAO);
        query.setMaxResults(amount);
        query.setFirstResult(displacement);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
    }
}
