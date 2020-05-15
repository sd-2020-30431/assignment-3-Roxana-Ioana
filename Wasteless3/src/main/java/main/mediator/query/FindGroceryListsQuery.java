package main.mediator.query;

import main.mediator.*;

public class FindGroceryListsQuery implements Request {

    private int idUser;

    public FindGroceryListsQuery(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
