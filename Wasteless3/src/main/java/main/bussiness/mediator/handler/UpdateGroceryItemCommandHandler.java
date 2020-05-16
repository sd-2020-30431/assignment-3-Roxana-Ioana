package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class UpdateGroceryItemCommandHandler implements Handler<UpdateGroceryItemCommand, UpdateGroceryItemCommandResponse> {

    private final GroceryItemCommandService commandService;

    @Autowired
    public UpdateGroceryItemCommandHandler(GroceryItemCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public UpdateGroceryItemCommandResponse handle(UpdateGroceryItemCommand q) {
        commandService.updateItem(q.getGroceryItem());
        return null;
    }
}
