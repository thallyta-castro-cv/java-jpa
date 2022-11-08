package com.thallyta.relationship.repositories.manytoone;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.manytoone.RequestItemModel;
import com.thallyta.relationship.models.manytoone.RequestModel;

public class SelectRequest {

    public static void main(String[] args) {
        DAO<RequestModel> dao = new DAO<>(RequestModel.class);

        RequestModel request = dao.getById(1L);

        for(RequestItemModel item: request.getItems()) {
            System.out.println(item.getAmount());
            System.out.println(item.getProduct().getName());
        }

        dao.close();
    }
}
