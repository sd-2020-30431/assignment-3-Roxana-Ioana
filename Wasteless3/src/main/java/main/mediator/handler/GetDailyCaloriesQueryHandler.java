package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.query.*;
import main.mediator.response.*;
import org.springframework.stereotype.*;

@Component
public class GetDailyCaloriesQueryHandler implements Handler<GetDailyCaloriesQuery, GetDailyCaloriesQueryResponse> {


    @Override
    public GetDailyCaloriesQueryResponse handle(GetDailyCaloriesQuery q) {
        return null;
    }
}
