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
public class GetExpireGroceryItemsQueryHandler implements Handler<GetExpireGroceryItemsQuery, GetExpireGroceryItemsQueryResponse> {

    private final GroceryItemQueryService queryService;

    @Autowired
    public GetExpireGroceryItemsQueryHandler(GroceryItemQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public GetExpireGroceryItemsQueryResponse handle(GetExpireGroceryItemsQuery q) {
        List<GroceryItem> groceryItemList = queryService.getGroceryItemsWhichExpire(q.getIdUser());
        return new GetExpireGroceryItemsQueryResponse(groceryItemList);
    }
}
