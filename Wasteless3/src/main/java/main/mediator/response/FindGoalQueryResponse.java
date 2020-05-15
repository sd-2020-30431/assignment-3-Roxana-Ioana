package main.mediator.response;

import main.mediator.*;
import main.model.*;

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
