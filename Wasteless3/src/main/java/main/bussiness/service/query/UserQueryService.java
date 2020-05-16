package main.bussiness.service.query;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    @Autowired
    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String username, String password) {
        return Optional.ofNullable(userRepository.findByUsernameAndPassword(username, password));
    }
}
