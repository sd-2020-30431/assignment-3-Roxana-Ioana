package main.mediator.response;

import main.mediator.*;
import main.model.*;

import java.util.*;

public class FindGroceryListsQueryResponse implements Response {

    private List<GroceryList> groceryLists;

    public FindGroceryListsQueryResponse(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }

    public List<GroceryList> getGroceryLists() {
        return groceryLists;
    }

    public void setGroceryLists(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }
}
