package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;

public class DeleteGroceryListCommandHandler implements Handler<DeleteGroceryListCommand, DeleteGroceryListCommandResponse> {

    @Override
    public DeleteGroceryListCommandResponse handle(DeleteGroceryListCommand q) {
        return null;
    }
}
