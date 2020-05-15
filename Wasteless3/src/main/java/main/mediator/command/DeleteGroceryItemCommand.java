package main.mediator.command;

import main.mediator.*;

public class DeleteGroceryItemCommand implements Request {

    private int idGroceryItem;

    public DeleteGroceryItemCommand(int idGroceryItem) {
        this.idGroceryItem = idGroceryItem;
    }

    public int getIdGroceryItem() {
        return idGroceryItem;
    }

    public void setIdGroceryItem(int idGroceryItem) {
        this.idGroceryItem = idGroceryItem;
    }
}
