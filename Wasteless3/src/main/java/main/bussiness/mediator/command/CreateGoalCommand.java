package main.bussiness.mediator.command;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateGoalCommand implements Request {

    private Goal goal;

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public CreateGoalCommand(Goal goal) {
        this.goal = goal;
    }
}
