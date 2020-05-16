package main.bussiness.service.command;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserCommandService {

    private final UserRepository userRepository;

    @Autowired
    public UserCommandService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
