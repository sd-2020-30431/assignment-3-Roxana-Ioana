package main.bussiness.mediator.query;

import main.bussiness.mediator.*;

public class FindGoalQuery implements Request {

    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public FindGoalQuery(int idUser) {
        this.idUser = idUser;
    }
}

