package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateGroceryListCommandResponse implements Response {

    private GroceryList groceryList;

    public CreateGroceryListCommandResponse(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
