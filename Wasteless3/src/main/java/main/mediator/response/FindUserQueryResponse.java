package main.mediator.response;

import main.mediator.*;
import main.model.*;

import java.util.*;

public class FindUserQueryResponse implements Response {

    private Optional<User> user;

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }
}
