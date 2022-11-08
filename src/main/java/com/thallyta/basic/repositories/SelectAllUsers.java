package com.thallyta.basic.repositories;

import com.thallyta.basic.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtil;

import java.util.List;


public class SelectAllUsers {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        String jpql = "select u from UserModel u";
        TypedQuery<UserModel> query = entityManager.createQuery(jpql, UserModel.class);
        query.setMaxResults(5);

        List<UserModel> users = query.getResultList();

        for(UserModel user: users) {
            System.out.println("ID: " + user.getId() + " Nome: " + user.getName());
        }

        entityManager.close();
        JpaUtil.close();
    }
}
