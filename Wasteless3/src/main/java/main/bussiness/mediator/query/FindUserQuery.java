package main.bussiness.mediator.query;

import main.bussiness.mediator.*;

public class FindUserQuery implements Request {

    private String username;
    private String password;

    public FindUserQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
