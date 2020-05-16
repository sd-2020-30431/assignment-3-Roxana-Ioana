package main.dao.repository;

import main.bussiness.model.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByIdUser(int idUser);
}
