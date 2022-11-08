package com.thallyta.relationship.repositories.onetoone;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.onetone.ClientModel;
import com.thallyta.relationship.models.onetone.SeatModel;

public class NewClientSeatTwo {

    public static void main(String[] args) {

        SeatModel seat = new SeatModel("4D");
        ClientModel client = new ClientModel("Maria", seat);

        DAO<ClientModel> dao = new DAO<>(ClientModel.class);
        dao.includeAtomic(client);
    }
}
