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
public class FindGroceryItemsQueryHandler implements Handler<FindGroceryItemsQuery, FindGroceryItemsQueryResponse> {

    private final GroceryItemQueryService queryService;

    @Autowired
    public FindGroceryItemsQueryHandler(GroceryItemQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public FindGroceryItemsQueryResponse handle(FindGroceryItemsQuery q) {
        List<GroceryItem> groceryItemList = queryService.findByIdList(q.getIdList());
        return new FindGroceryItemsQueryResponse(groceryItemList);
    }
}
