package main.presentation.controller;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.presentation.dto.*;
import main.presentation.mapper.*;
import main.presentation.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/grocery-lists")
public class GroceryListController {

    private final Mediator mediator;
    private GroceryListMapper groceryListMapper;
    private GroceryListValidator groceryListValidator;

    @Autowired
    public GroceryListController(Mediator mediator) {
        groceryListMapper = new GroceryListMapper();
        groceryListValidator = new GroceryListValidator();
        this.mediator = mediator;
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryList>> getAllGroceryLists(@PathVariable("idUser") int idUser) {
        FindGroceryListsQuery request = new FindGroceryListsQuery(idUser);

        FindGroceryListsQueryHandler queryHandler = (FindGroceryListsQueryHandler)
                mediator.<FindGroceryListsQuery, FindGroceryListsQueryResponse>handle(request);
        FindGroceryListsQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getGroceryLists(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> createGroceryList(@RequestBody GroceryListDTO groceryListDTO) {
        try {
            groceryListValidator.validate(groceryListDTO);
            CreateGroceryListCommand request = new CreateGroceryListCommand(groceryListMapper.convertToGroceryList(groceryListDTO));

            CreateGroceryListCommandHandler queryHandler = (CreateGroceryListCommandHandler)
                    mediator.<CreateGroceryListCommand, CreateGroceryListCommandResponse>handle(request);
            CreateGroceryListCommandResponse response = queryHandler.handle(request);

            return new ResponseEntity<>(response.getGroceryList().getIdList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{idList}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGroceryList(@PathVariable("idList") int idList) {
        DeleteGroceryListCommand request = new DeleteGroceryListCommand(idList);

        DeleteGroceryListCommandHandler commandHandler = (DeleteGroceryListCommandHandler)
                mediator.<DeleteGroceryListCommand, DeleteGroceryListCommandResponse>handle(request);
        DeleteGroceryListCommandResponse response = commandHandler.handle(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
