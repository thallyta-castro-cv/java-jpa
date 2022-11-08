package com.thallyta.basic.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_users")
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = 200, nullable = false)
    private String name;

    @Column(name = "user_email", length = 200, nullable = false)
    private String email;

    public UserModel(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }
}
