package com.thallyta.relationship.models.queries;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;

@Data
@NamedNativeQuery(name = "gradeMovieMediaGeneral",
                  resultSetMapping = "gradeMovieMap",
                  query = "select avg(grade) as media from movies")
@SqlResultSetMapping(name = "gradeMovieMap",
                entities = @EntityResult(
                entityClass = GradeMovie.class,
                fields = {@FieldResult(name = "media", column = "media")}))
public class GradeMovie {

    private double media;

    public GradeMovie(double media) {
        super();
        this.media = media;
    }
}
