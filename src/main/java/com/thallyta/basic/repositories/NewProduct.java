package com.thallyta.basic.repositories;

import com.thallyta.basic.models.ProductModel;
import com.thallyta.basic.models.daos.DAO;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

public class NewProduct {
    public static void main(String[] args) {

        ProductModel product = new ProductModel("Notebook", 789.98);

        DAO<ProductModel> dao = new DAO<>(ProductModel.class);
        dao.includeAtomic(product).close();

        System.out.println("ID do produto: " + product.getId());
    }
}
