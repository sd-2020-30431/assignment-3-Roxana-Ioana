package main.mediator.command;

import main.mediator.*;
import main.model.*;

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
