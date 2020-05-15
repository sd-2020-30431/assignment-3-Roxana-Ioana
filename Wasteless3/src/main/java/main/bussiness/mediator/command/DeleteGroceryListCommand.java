package main.bussiness.mediator.command;

import main.bussiness.mediator.*;

public class DeleteGroceryListCommand implements Request {

    private int idList;

    public DeleteGroceryListCommand(int idList) {
        this.idList = idList;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }
}
