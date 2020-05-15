package main.mediator.command;

import main.mediator.*;

public class DeleteGroceryListCommand implements Request {

    private int idList;

    public DeleteGroceryListCommand(int idList) {
        this.idList = idList;
    }
}
