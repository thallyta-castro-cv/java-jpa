package com.thallyta.relationship.models.manytoone;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_requests")
public class RequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "date",nullable = false)
    private Date date;

    @OneToMany(mappedBy = "request")
    private List<RequestItemModel> items;

    public RequestModel() {
        this(new Date());
    }

    public RequestModel(Date date) {
        super();
        this.date = date;
    }

}
