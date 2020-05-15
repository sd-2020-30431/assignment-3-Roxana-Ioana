package main.mediator.command;

import main.mediator.*;
import main.model.*;

public class CreateUserCommand implements Request {

    private User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }
}
