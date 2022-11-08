package com.thallyta.basic.repositories;

import com.thallyta.basic.models.UserModel;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class DeleteUser {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        UserModel user = entityManager.find(UserModel.class, 3L);

        if(user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
        JpaUtil.close();
    }
}
