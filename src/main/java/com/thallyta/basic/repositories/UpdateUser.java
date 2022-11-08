package com.thallyta.basic.repositories;

import com.thallyta.basic.models.UserModel;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class UpdateUser {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        entityManager.getTransaction().begin();

        UserModel user = entityManager.find(UserModel.class, 3L);
        user.setName("Leonardo");
        user.setEmail("leonardo@lanche.com.br");

        entityManager.merge(user);

        entityManager.getTransaction().commit();

        entityManager.close();
        JpaUtil.close();
    }
}
