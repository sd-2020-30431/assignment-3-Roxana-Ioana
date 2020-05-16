package main.presentation.controller;

import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.presentation.dto.*;
import main.presentation.mapper.*;
import main.presentation.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/authenticate")
public class UserController {

    private final Mediator mediator;
    private UserMapper userMapper;
    private UserValidator userValidator;

    @Autowired
    public UserController(Mediator mediator) {
        this.userMapper = new UserMapper();
        userValidator = new UserValidator();
        this.mediator = mediator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> findUser(@RequestBody UserDTO userDTO) {
        //Optional<User> foundUser = userService.findUser(userDTO.getUsername(), userDTO.getPassword());

        FindUserQuery query = new FindUserQuery(userDTO.getUsername(), userDTO.getPassword());
        FindUserQueryHandler handler = (FindUserQueryHandler) mediator.<FindUserQuery, FindUserQueryResponse>getHandler(query);
        FindUserQueryResponse response = handler.handle(query);

        if (response.getUser() != null) {
            return new ResponseEntity<>(response.getUser().getIdUser(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO) {
        try {
            userValidator.validate(userDTO);
            //User user = userService.createUser();

            CreateUserCommand command = new CreateUserCommand(userMapper.convertToUser(userDTO));
            CreateUserCommandHandler handler = (CreateUserCommandHandler) mediator.<CreateUserCommand, CreateUserCommandResponse>getHandler(command);
            CreateUserCommandResponse response = handler.handle(command);

            return new ResponseEntity<>(response.getUser().getIdUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
