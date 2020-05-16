package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

import java.util.*;

public class FindGroceryItemsQueryResponse implements Response {

    private List<GroceryItem> groceryItemList;

    public FindGroceryItemsQueryResponse(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }
}

