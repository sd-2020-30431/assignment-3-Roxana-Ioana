package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;
import org.springframework.stereotype.*;

@Component
public class CreateGoalCommandHandler implements Handler<CreateGoalCommand, CreateGoalCommandResponse> {

    @Override
    public CreateGoalCommandResponse handle(CreateGoalCommand q) {
        return null;
    }
}
