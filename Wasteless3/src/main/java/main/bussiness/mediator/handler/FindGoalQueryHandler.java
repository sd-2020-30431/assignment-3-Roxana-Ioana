package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.query.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class FindGoalQueryHandler implements Handler<FindGoalQuery, FindGoalQueryResponse> {

    private final GoalQueryService queryService;

    @Autowired
    public FindGoalQueryHandler(GoalQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public FindGoalQueryResponse handle(FindGoalQuery q) {
        Goal goal = queryService.getGoal(q.getIdUser());
        return new FindGoalQueryResponse(goal);
    }
}
