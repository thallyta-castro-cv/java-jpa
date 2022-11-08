package com.thallyta.relationship.repositories.manytomany;

import com.thallyta.relationship.models.daos.DAO;

public class NewMovieActor {

    public static void main(String[] args) {

        MovieModel movieA = new MovieModel("Star Wars Ep 4", 8.9);
        MovieModel movieB = new MovieModel("O Fugitivo", 8.1);

        ActorModel actorA = new ActorModel("Harrison Ford");
        ActorModel actressB = new ActorModel("Carrie Fisher");

        movieA.addActor(actorA);
        movieA.addActor(actressB);

        movieB.addActor(actorA);

        DAO<MovieModel> dao = new DAO<MovieModel>();
        dao.includeAtomic(movieA);
    }
}
