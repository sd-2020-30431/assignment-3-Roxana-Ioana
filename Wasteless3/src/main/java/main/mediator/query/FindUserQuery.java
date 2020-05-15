package main.mediator.query;

import main.mediator.*;

public class FindUserQuery implements Request {

    private String username;
    private String password;

    public FindUserQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
