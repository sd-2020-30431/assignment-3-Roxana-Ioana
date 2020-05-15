package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class DeleteGroceryItemCommandHandler implements Handler<DeleteGroceryItemCommand, DeleteGroceryItemCommandResponse> {

    private final GroceryItemCommandService commandService;

    @Autowired
    public DeleteGroceryItemCommandHandler(GroceryItemCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public DeleteGroceryItemCommandResponse handle(DeleteGroceryItemCommand q) {
        commandService.deleteItem(q.getIdGroceryItem());
        return new DeleteGroceryItemCommandResponse();
    }
}
