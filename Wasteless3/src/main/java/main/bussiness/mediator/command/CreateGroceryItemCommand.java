package main.bussiness.mediator.command;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

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
