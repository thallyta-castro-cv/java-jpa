package com.thallyta.relationship.repositories.onetoone;

import com.thallyta.relationship.models.daos.DAO;
import com.thallyta.relationship.models.onetone.ClientModel;
import com.thallyta.relationship.models.onetone.SeatModel;

public class SelectClientSeat {

    public static void main(String[] args) {

        DAO<ClientModel> daoClient = new DAO<>(ClientModel.class);
        ClientModel client = daoClient.getById(1L);
        System.out.println(client.getSeat().getName());

        daoClient.close();

        DAO<SeatModel> daoSeat = new DAO<>(SeatModel.class);
        SeatModel seat = daoSeat.getById(1L);
        System.out.println(seat.getClient().getName());

        daoSeat.close();
    }

}
