package com.thallyta.relationship.models.onetone;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_clients")
public class ClientModel {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seat_id", unique = true)
    private SeatModel seat;

    public ClientModel(String name, SeatModel seat) {
        this.name = name;
        this.seat = seat;
    }
}
