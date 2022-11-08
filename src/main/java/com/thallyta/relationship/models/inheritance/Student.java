package com.thallyta.relationship.models.inheritance;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")
@Table(name = "tb_student")
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "registration")
    private Long registration;

    @Column(name = "name")
    private String name;

    public Student(Long registration, String name) {
        super();
        this.registration = registration;
        this.name = name;
    }
}
