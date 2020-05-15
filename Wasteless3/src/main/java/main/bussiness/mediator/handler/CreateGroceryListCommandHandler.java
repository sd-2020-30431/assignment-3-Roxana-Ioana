package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CreateGroceryListCommandHandler implements Handler<CreateGroceryListCommand, CreateGroceryListCommandResponse> {

    private final GroceryListCommandService commandService;

    @Autowired
    public CreateGroceryListCommandHandler(GroceryListCommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public CreateGroceryListCommandResponse handle(CreateGroceryListCommand q) {
        GroceryList groceryList = commandService.createNewList(q.getGroceryList());
        return new CreateGroceryListCommandResponse(groceryList);
    }
}
