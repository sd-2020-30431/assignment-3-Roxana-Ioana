package main.mediator.command;

import main.mediator.*;
import main.model.*;

public class CreateGroceryItemCommand implements Request {

    private GroceryItem groceryItem;

    public CreateGroceryItemCommand(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    public void setGroceryItem(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }
}
