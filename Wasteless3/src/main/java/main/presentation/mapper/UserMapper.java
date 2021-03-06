package main.presentation.mapper;

import main.bussiness.model.*;
import main.presentation.dto.*;

public class UserMapper {

    public User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setIdUser(userDTO.getIdUser());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser(user.getIdUser());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
