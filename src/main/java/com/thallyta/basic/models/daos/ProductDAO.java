package com.thallyta.basic.models.daos;

import com.thallyta.basic.models.ProductModel;

public class ProductDAO extends DAO<ProductModel>{

    public ProductDAO() {
        super(ProductModel.class);
    }
}
