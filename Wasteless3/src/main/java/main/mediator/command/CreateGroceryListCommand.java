package main.mediator.command;

import main.mediator.*;
import main.model.*;

public class CreateGroceryListCommand implements Request {

    private GroceryList groceryList;

    public CreateGroceryListCommand(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
