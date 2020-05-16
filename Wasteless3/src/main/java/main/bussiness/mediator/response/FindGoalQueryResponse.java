package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class FindGoalQueryResponse implements Response {

    private Goal goal;

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public FindGoalQueryResponse(Goal goal) {
        this.goal = goal;
    }
}
