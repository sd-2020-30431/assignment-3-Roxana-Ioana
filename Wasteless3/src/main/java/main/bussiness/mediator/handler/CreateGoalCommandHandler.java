package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CreateGoalCommandHandler implements Handler<CreateGoalCommand, CreateGoalCommandResponse> {

    private final GoalCommandService goalCommandService;

    @Autowired
    public CreateGoalCommandHandler(GoalCommandService goalCommandService) {
        this.goalCommandService = goalCommandService;
    }

    @Override
    public CreateGoalCommandResponse handle(CreateGoalCommand q) {
        Goal goal = goalCommandService.createGoal(q.getGoal());
        return new CreateGoalCommandResponse(goal);
    }
}
