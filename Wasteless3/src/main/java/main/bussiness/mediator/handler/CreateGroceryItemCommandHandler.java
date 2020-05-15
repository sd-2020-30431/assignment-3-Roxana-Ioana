package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.command.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CreateGroceryItemCommandHandler implements Handler<CreateGroceryItemCommand, CreateGroceryItemCommandResponse> {

    private final GroceryItemCommandService groceryItemService;

    @Autowired
    public CreateGroceryItemCommandHandler(GroceryItemCommandService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @Override
    public CreateGroceryItemCommandResponse handle(CreateGroceryItemCommand request) {
        return new CreateGroceryItemCommandResponse(groceryItemService.addGroceryItem(
                request.getGroceryItem()
        ));
    }
}
