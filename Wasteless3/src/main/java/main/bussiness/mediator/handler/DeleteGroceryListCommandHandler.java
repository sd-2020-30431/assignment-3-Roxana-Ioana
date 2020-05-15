package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class DeleteGroceryListCommandHandler implements Handler<DeleteGroceryListCommand, DeleteGroceryListCommandResponse> {

    private final GroceryListCommandService commandService;

    @Autowired
    public DeleteGroceryListCommandHandler(GroceryListCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public DeleteGroceryListCommandResponse handle(DeleteGroceryListCommand q) {
        commandService.deleteList(q.getIdList());
        return null;
    }
}
