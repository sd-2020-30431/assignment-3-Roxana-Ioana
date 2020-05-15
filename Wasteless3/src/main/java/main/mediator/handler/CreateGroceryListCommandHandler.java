package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;
import org.springframework.stereotype.*;

@Component
public class CreateGroceryListCommandHandler implements Handler<CreateGroceryListCommand, CreateGroceryListCommandResponse> {

    @Override
    public CreateGroceryListCommandResponse handle(CreateGroceryListCommand q) {
        return null;
    }
}
