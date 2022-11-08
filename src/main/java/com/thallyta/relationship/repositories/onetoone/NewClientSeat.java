package com.thallyta.relationship.repositories.onetoone;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.onetone.ClientModel;
import com.thallyta.relationship.models.onetone.SeatModel;

public class NewClientSeat {

    public static void main(String[] args) {

        SeatModel seat = new SeatModel("16A");
        ClientModel client = new ClientModel("Carlos", seat);

        DAO<Object> dao = new DAO<>();

        dao.openTransaction()
                .include(seat)
                .include(client)
                .closeTransaction()
                .close();
    }

}
