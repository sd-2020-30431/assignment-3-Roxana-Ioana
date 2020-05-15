package main.mediator.response;

import main.mediator.*;
import main.model.*;

public class CreateGroceryItemCommandResponse implements Response {

    private GroceryItem groceryItem;

    public CreateGroceryItemCommandResponse(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    public void setGroceryItem(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }
}
