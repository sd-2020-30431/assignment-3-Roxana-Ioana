package main.bussiness.mediator.command;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateGroceryListCommand implements Request {

    private GroceryList groceryList;

    public CreateGroceryListCommand(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
