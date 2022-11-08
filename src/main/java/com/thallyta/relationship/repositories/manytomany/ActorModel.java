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
@Table(name = "tb_actor")
public class ActorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.PERSIST)
    private List<MovieModel> movies = new ArrayList<>();

    public ActorModel(String name) {
        super();
        this.name = name;
    }
}
