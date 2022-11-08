package com.thallyta.relationship.models.onetone;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_seat")
public class SeatModel {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //Associação bidirecional
    @OneToOne(mappedBy = "seat")
    private ClientModel client;

    public SeatModel(String name) {
        super();
        this.name = name;
    }
}
