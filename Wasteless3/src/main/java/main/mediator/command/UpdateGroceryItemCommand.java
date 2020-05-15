package main.mediator.command;

import main.mediator.*;
import main.model.*;

public class UpdateGroceryItemCommand implements Request {

    private GroceryItem groceryItem;

    public UpdateGroceryItemCommand(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }
}
