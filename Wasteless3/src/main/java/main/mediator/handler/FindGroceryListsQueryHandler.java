package main.mediator.handler;

import main.mediator.*;
import main.mediator.query.*;
import main.mediator.response.*;

public class FindGroceryListsQueryHandler implements Handler<FindGroceryListsQuery, FindGroceryListsQueryResponse> {

    @Override
    public FindGroceryListsQueryResponse handle(FindGroceryListsQuery q) {
        return null;
    }

    public static class DeleteGroceryListCommandHandler implements Response {
    }
}
