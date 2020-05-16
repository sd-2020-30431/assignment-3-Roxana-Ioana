package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

import java.util.*;

public class GetExpireGroceryItemsQueryResponse implements Response {

    private List<GroceryItem> groceryItemList;

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }

    public GetExpireGroceryItemsQueryResponse(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }
}
