package main.bussiness.mediator.command;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateUserCommand implements Request {

    private User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
