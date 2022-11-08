package com.thallyta.relationship.repositories.manytomany;

import com.thallyta.relationship.models.daos.DAO;

public class NewUncleNephew {

    public static void main(String[] args) {
        UncleModel uncle1 = new UncleModel("Maria");
        UncleModel uncle2 = new UncleModel("João");

        NephewModel nephew1 = new NephewModel("Davi");
        NephewModel nephew2 = new NephewModel("Ana");

        uncle1.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle1);

        uncle1.getNephews().add(nephew2);
        nephew2.getUncles().add(uncle1);

        uncle2.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle2);

        uncle2.getNephews().add(nephew2);
        nephew2.getUncles().add(uncle2);

        DAO<Object> dao = new DAO<>();
        dao.openTransaction()
                .include(uncle1)
                .include(nephew2)
                .include(nephew1)
                .include(nephew2)
                .closeTransaction()
                .close();
    }
}
