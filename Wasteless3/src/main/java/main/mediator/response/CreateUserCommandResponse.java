package main.mediator.response;

import main.mediator.*;
import main.model.*;

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
