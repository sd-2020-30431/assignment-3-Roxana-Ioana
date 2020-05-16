package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.query.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class GetDailyCaloriesQueryHandler implements Handler<GetDailyCaloriesQuery, GetDailyCaloriesQueryResponse> {

    private final GoalQueryService queryService;

    @Autowired
    public GetDailyCaloriesQueryHandler(GoalQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public GetDailyCaloriesQueryResponse handle(GetDailyCaloriesQuery q) {
        int calories = queryService.getNecessaryDailyCalories(q.getIdUser());
        return new GetDailyCaloriesQueryResponse(calories);
    }
}
