package com.thallyta.relationship.repositories.queries;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.repositories.manytomany.ActorModel;
import com.thallyta.relationship.repositories.manytomany.MovieModel;

import java.util.List;

public class getMovies {

    public static void main(String[] args) {

        DAO<MovieModel> dao = new DAO<>(MovieModel.class);
        List<MovieModel> films = dao.consult(
                "getMoviesWithGradeHigherThan", "grade", 8.5);

        for(MovieModel film: films) {
            System.out.println(film.getName()
                    + " => " + film.getGrade());

            for(ActorModel actor: film.getActors()) {
                System.out.println(actor.getName());
            }
        }
    }
}

