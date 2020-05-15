package main.bussiness.mediator.query;

import main.bussiness.mediator.*;

public class FindGroceryItemsQuery implements Request {

    private int idList;

    public FindGroceryItemsQuery(int idList) {
        this.idList = idList;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }
}
