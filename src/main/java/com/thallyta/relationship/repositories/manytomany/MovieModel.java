package com.thallyta.relationship.repositories.manytomany;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_movie")
@NamedQuery(name = "getMoviesWithGradeHigherThan",
            query = "select distinct m from MovieModel m " +
                    "join fetch m.actors " +
                    "where m.grade > :grade")
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "grade")
    @Getter
    @Setter
    private Double grade;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "actors_movies",
            joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id")
    )
    @Setter
    private List<ActorModel> actors;

    public MovieModel(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public List<ActorModel> getActors() {
        if(actors == null) {
            actors = new ArrayList<>();
        }
        return actors;
    }

    public void addActor(ActorModel actor) {
        if(actor != null && !getActors().contains(actor)) {
            getActors().add(actor);

            if(!actor.getMovies().contains(this)) {
                actor.getMovies().add(this);
            }
        }
    }
}
