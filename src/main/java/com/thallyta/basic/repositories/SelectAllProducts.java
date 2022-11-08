package com.thallyta.basic.repositories;

import com.thallyta.basic.models.ProductModel;
import com.thallyta.basic.models.daos.ProductDAO;

import java.util.List;

public class SelectAllProducts {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        List<ProductModel> products = productDAO.getAll();

        for(ProductModel product: products) {
            System.out.println("ID: " + product.getId() + ", Nome: "
                    + product.getName());
        }

        double priceTotal = products
                .stream()
                .map(ProductModel::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("O valor total é R$ " + priceTotal);

        productDAO.close();
    }
}
