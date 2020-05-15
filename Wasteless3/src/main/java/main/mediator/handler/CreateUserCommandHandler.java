package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;

public class CreateUserCommandHandler implements Handler<CreateUserCommand, CreateUserCommandResponse> {

    @Override
    public CreateUserCommandResponse handle(CreateUserCommand q) {
        return null;
    }
}
