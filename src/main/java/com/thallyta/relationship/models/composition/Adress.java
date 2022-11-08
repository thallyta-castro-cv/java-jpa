package com.thallyta.relationship.models.composition;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Adress {

    private String street;
    private String complement;

    public Adress(String street, String complement) {
        super();
        this.street = street;
        this.complement = complement;
    }
}
