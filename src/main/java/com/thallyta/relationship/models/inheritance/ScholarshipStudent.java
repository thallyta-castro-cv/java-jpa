package com.thallyta.relationship.models.inheritance;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("AB")
@NoArgsConstructor
@Table(name = "tb_scholarship_student")
public class ScholarshipStudent extends Student {

    @Column(name = "scholarship_value")
    private double scholarshipValue;

    public ScholarshipStudent(Long registration, String name, double scholarshipValue) {
        super(registration, name);
        this.scholarshipValue = scholarshipValue;
    }
}
