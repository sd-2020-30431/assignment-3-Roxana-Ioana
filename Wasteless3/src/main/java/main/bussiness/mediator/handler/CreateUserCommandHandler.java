package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CreateUserCommandHandler implements Handler<CreateUserCommand, CreateUserCommandResponse> {

    private final UserCommandService commandService;

    @Autowired
    public CreateUserCommandHandler(UserCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public CreateUserCommandResponse handle(CreateUserCommand q) {
        User user = commandService.createUser(q.getUser());
        return new CreateUserCommandResponse(user);
    }
}
