package com.thallyta.relationship.models.manytoone;

import com.thallyta.basic.models.ProductModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "tb_request_items")
public class RequestItemModel {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    private RequestModel request;

    @ManyToOne
    @Getter
    private ProductModel product;

    @Getter
    @Setter
    @Column(name = "amount", nullable = false)
    private int amount;

    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Double price;

    public RequestItemModel(RequestModel request, ProductModel product, int amount) {
        super();
        this.setRequest(request);
        this.setProduct(product);
        this.setAmount(amount);
    }

    public void setProduct(ProductModel product) {
        this.product = product;

        if(product != null && this.price == null) {
            this.setPrice(product.getPrice());
        }
    }

}
