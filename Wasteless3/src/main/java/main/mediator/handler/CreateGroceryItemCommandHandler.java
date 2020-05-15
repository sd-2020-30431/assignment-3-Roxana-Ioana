package main.mediator.handler;

import main.mediator.*;
import main.mediator.command.*;
import main.mediator.response.*;
import main.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class CreateGroceryItemCommandHandler implements Handler<CreateGroceryItemCommand, CreateGroceryItemCommandResponse> {

    @Autowired
    private final GroceryItemCommandService groceryItemService;

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
