package main.mediator.response;

import main.mediator.*;
import main.model.*;

import java.util.*;

public class GetExpireGroceryItemsQueryResponse implements Response {

    private List<GroceryItem> groceryItemList;

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }
}
