package com.thallyta.basic.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "price")
    private Double price;

    public ProductModel(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

}