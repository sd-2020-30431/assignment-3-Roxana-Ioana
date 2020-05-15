package main.presentation.controller;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.presentation.dto.*;
import main.presentation.mapper.*;
import main.presentation.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/goal")
public class GoalController {

    private final Mediator mediator;
    private GoalMapper goalMapper;
    private GoalValidator goalValidator;

    @Autowired
    public GoalController(Mediator mediator) {
        this.goalMapper = new GoalMapper();
        this.goalValidator = new GoalValidator();
        this.mediator = mediator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CreateGoalCommandResponse> createGoal(@RequestBody GoalDTO goalDTO) {
        try {
            goalValidator.validate(goalDTO);

            CreateGoalCommand request = new CreateGoalCommand(goalMapper.convert(goalDTO));

            CreateGoalCommandHandler commandHandler = (CreateGoalCommandHandler)
                    mediator.<CreateGoalCommand, CreateGoalCommandResponse>handle(request);
            CreateGoalCommandResponse response = commandHandler.handle(request);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getGoal(@PathVariable("idUser") int idUser) {

        FindGoalQuery request = new FindGoalQuery(idUser);

        FindGoalQueryHandler queryHandler = (FindGoalQueryHandler)
                mediator.<FindGoalQuery, FindGoalQueryResponse>handle(request);

        FindGoalQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getGoal().getDailyCalories(), HttpStatus.OK);
    }

    @RequestMapping(value = "/dailyCalories/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getDailyCalories(@PathVariable("idUser") int idUser) {

        GetDailyCaloriesQuery request = new GetDailyCaloriesQuery(idUser);

        GetDailyCaloriesQueryHandler queryHandler = (GetDailyCaloriesQueryHandler)
                mediator.<GetDailyCaloriesQuery, GetDailyCaloriesQueryResponse>handle(request);

        GetDailyCaloriesQueryResponse response = queryHandler.handle(request);

        //int calories = goalService.getNecessaryDailyCalories(idUser);

        return new ResponseEntity<>(response.getCalories(), HttpStatus.OK);
    }
}
