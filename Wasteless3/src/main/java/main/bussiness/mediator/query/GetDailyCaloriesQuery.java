package main.bussiness.mediator.query;

import main.bussiness.mediator.*;

public class GetDailyCaloriesQuery implements Request {

    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public GetDailyCaloriesQuery(int idUser) {
        this.idUser = idUser;
    }
}
