package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class CreateUserCommandResponse implements Response {

    private User user;

    public CreateUserCommandResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
