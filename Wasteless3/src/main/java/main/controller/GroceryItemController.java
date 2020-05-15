package main.controller;

import main.dto.*;
import main.mapper.*;
import main.mediator.*;
import main.mediator.command.*;
import main.mediator.handler.*;
import main.mediator.query.*;
import main.mediator.response.*;
import main.model.*;
import main.service.*;
import main.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.*;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/grocery-items")
public class GroceryItemController {

    private final Mediator mediator;
    private GroceryItemMapper groceryItemMapper;
    private GroceryItemValidator groceryItemValidator;

    @Autowired
    public GroceryItemController(Mediator mediator) {
        groceryItemMapper = new GroceryItemMapper();
        groceryItemValidator = new GroceryItemValidator();
        this.mediator = mediator;
    }

    @RequestMapping(value = "/{idList}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryItem>> findItemsByIdList(@PathVariable("idList") int idList) {

        //List<GroceryItem> itemsList = groceryItemService.findByIdList(idList);

        FindGroceryItemsQuery request = new FindGroceryItemsQuery(idList);

        FindGroceryItemsQueryHandler queryHandler = (FindGroceryItemsQueryHandler)
                mediator.<FindGroceryItemsQuery, FindGroceryItemsQueryResponse>handle(request);
        FindGroceryItemsQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getGroceryItemList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> addGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO) {
        try {
            groceryItemValidator.validate(groceryItemDTO);

            CreateGroceryItemCommand request = new CreateGroceryItemCommand(groceryItemMapper.convertToGroceryItem(groceryItemDTO));

            CreateGroceryItemCommandHandler commandHandler = (CreateGroceryItemCommandHandler)
                    mediator.<CreateGroceryItemCommand, CreateGroceryItemCommandResponse>handle(request);
            CreateGroceryItemCommandResponse response = commandHandler.handle(request);

            return new ResponseEntity<>(request.getGroceryItem().getIdItem(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @Transactional
    @RequestMapping(value = "/{idItem}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable("idItem") int idItem) {
       // groceryItemService.deleteItem(idItem);

        DeleteGroceryItemCommand request = new DeleteGroceryItemCommand(idItem);

        DeleteGroceryItemCommandHandler commandHandler = (DeleteGroceryItemCommandHandler)
                mediator.<DeleteGroceryItemCommand, DeleteGroceryItemCommandResponse>handle(request);
        DeleteGroceryItemCommandResponse response = commandHandler.handle(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO) {
      //  groceryItemService.updateItem(groceryItemMapper.convertToGroceryItem(groceryItemDTO));

        UpdateGroceryItemCommand request = new UpdateGroceryItemCommand(groceryItemMapper.convertToGroceryItem(groceryItemDTO));

        UpdateGroceryItemCommandHandler commandHandler = (UpdateGroceryItemCommandHandler)
                mediator.<UpdateGroceryItemCommand, UpdateGroceryItemCommandResponse>handle(request);
        UpdateGroceryItemCommandResponse response = commandHandler.handle(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/to-expire/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryItem>> getGroceryItemsWhichExpire(@PathVariable("idUser") int idUser) {
      //  List<GroceryItem> groceryItems = groceryItemService.getGroceryItemsWhichExpire(idUser);

        GetExpireGroceryItemsQuery request = new GetExpireGroceryItemsQuery(idUser);

        GetExpireGroceryItemsQueryHandler queryHandler = (GetExpireGroceryItemsQueryHandler)
                mediator.<GetExpireGroceryItemsQuery, GetExpireGroceryItemsQueryResponse>handle(request);
        GetExpireGroceryItemsQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getGroceryItemList(), HttpStatus.OK);
    }
}
