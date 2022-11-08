package com.thallyta.relationship.repositories.manytomany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_nephew")
public class NephewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToMany(mappedBy = "nephews")
    private List<UncleModel> uncles = new ArrayList<>();

    public NephewModel(String nome) {
        super();
        this.name = nome;
    }
}
