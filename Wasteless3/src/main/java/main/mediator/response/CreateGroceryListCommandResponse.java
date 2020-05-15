package main.mediator.response;

import main.mediator.*;
import main.model.*;

public class CreateGroceryListCommandResponse implements Response {

    private GroceryList groceryList;

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
