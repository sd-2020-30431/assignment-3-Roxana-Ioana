package main.presentation.mapper;

import main.bussiness.model.*;
import main.presentation.dto.*;

public class GoalMapper {

    public Goal convert(GoalDTO goalDTO) {
        Goal goal = new Goal();

        goal.setIdUser(goalDTO.getIdUser());
        goal.setIdGoal(goalDTO.getIdGoal());
        goal.setDailyCalories(goalDTO.getDailyCalories());

        return goal;
    }

    public GoalDTO convertToDTO(Goal goal) {
        GoalDTO goalDTO = new GoalDTO();

        goalDTO.setIdUser(goal.getIdUser());
        goalDTO.setIdGoal(goal.getIdGoal());
        goalDTO.setDailyCalories(goal.getDailyCalories());

        return goalDTO;
    }
}
