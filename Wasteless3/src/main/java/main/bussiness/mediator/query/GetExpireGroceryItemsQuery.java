package main.bussiness.mediator.query;

import main.bussiness.mediator.*;

public class GetExpireGroceryItemsQuery implements Request {

    private int idUser;

    public GetExpireGroceryItemsQuery(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
