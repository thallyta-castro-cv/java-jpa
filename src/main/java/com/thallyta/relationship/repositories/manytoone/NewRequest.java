package com.thallyta.relationship.repositories.manytoone;

import com.thallyta.basic.models.ProductModel;
import com.thallyta.basic.models.daos.DAO;
import com.thallyta.relationship.models.manytoone.RequestItemModel;
import com.thallyta.relationship.models.manytoone.RequestModel;

public class NewRequest {

    public static void main(String[] args) {

        DAO<Object> dao = new DAO<Object>();

        RequestModel request = new RequestModel();
        ProductModel product = new ProductModel("Geladeira", 2789.99);
        RequestItemModel requestItem = new RequestItemModel(request, product, 10);

        dao.openTransaction()
                .include(product)
                .include(request)
                .include(requestItem)
                .closeTransaction()
                .close();
    }
}
