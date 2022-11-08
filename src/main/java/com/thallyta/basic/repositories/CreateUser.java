package com.thallyta.basic.repositories;

import com.thallyta.basic.models.UserModel;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class CreateUser {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        UserModel newUser = new UserModel("Davi", "davi@email.com.br");

        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

        System.out.println("O Id gerado foi: " + newUser.getId());

        entityManager.close();
        JpaUtil.close();
    }
}
