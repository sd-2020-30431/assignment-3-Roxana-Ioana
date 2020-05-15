package main.mediator.query;

import main.mediator.*;

public class GetExpireGroceryItemsQuery implements Request {

    private int idUser;

    public GetExpireGroceryItemsQuery(int idUser) {
        this.idUser = idUser;
    }
}
