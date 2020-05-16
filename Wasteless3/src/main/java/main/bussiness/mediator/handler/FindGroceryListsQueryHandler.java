package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.query.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class FindGroceryListsQueryHandler implements Handler<FindGroceryListsQuery, FindGroceryListsQueryResponse> {

    private final GroceryListQueryService queryService;

    @Autowired
    public FindGroceryListsQueryHandler(GroceryListQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public FindGroceryListsQueryResponse handle(FindGroceryListsQuery q) {
        List<GroceryList> groceryLists = queryService.selectAllLists(q.getIdUser());
        return new FindGroceryListsQueryResponse(groceryLists);
    }

}
