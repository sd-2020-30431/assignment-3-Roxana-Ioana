package main.controller;

import main.dto.*;
import main.mapper.*;
import main.mediator.*;
import main.mediator.command.*;
import main.mediator.handler.*;
import main.mediator.query.*;
import main.mediator.response.*;
import main.model.*;
import main.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        FindUserQueryHandler handler = (FindUserQueryHandler) mediator.<FindUserQuery, FindUserQueryResponse>handle(query);
        FindUserQueryResponse response = handler.handle(query);
        Optional<User> user = response.getUser();

        return user.map(foundUser -> new ResponseEntity<>(user.get().getIdUser(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO) {
        try {
            userValidator.validate(userDTO);
            //User user = userService.createUser();

            CreateUserCommand command = new CreateUserCommand(userMapper.convertToUser(userDTO));
            CreateUserCommandHandler handler = (CreateUserCommandHandler) mediator.<CreateUserCommand, CreateUserCommandResponse>handle(command);
            CreateUserCommandResponse response = handler.handle(command);

            return new ResponseEntity<>(response.getUser().getIdUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
