package com.thallyta.basic.repositories;

import com.thallyta.basic.models.UserModel;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class SelectUserById {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        UserModel user = entityManager.find(UserModel.class, 2L);
        System.out.println(user.getName());

        entityManager.close();
        JpaUtil.close();
    }
}
