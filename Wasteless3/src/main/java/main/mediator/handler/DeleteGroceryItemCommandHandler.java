package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;

public class DeleteGroceryItemCommandHandler implements Handler<DeleteGroceryItemCommand, DeleteGroceryItemCommandResponse> {

    @Override
    public DeleteGroceryItemCommandResponse handle(DeleteGroceryItemCommand q) {
        return null;
    }
}
