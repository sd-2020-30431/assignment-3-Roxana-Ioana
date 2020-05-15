package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateGoalCommandResponse implements Response {

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public CreateGoalCommandResponse(Goal goal) {
        this.goal = goal;
    }

    private Goal goal;

}
