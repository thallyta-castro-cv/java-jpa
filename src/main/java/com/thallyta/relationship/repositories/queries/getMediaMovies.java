package com.thallyta.relationship.repositories.queries;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.queries.GradeMovie;

public class getMediaMovies {

    public static void main(String[] args) {

        DAO<GradeMovie> dao = new DAO<>(GradeMovie.class);
        GradeMovie grade = dao.consultOne("gradeMovieMediaGeneral");

        System.out.println(grade.getMedia());

        dao.close();
    }
}
