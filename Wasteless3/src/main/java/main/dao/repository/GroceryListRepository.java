package main.dao.repository;

import main.bussiness.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {

    GroceryList save(GroceryList groceryList);

    ArrayList<GroceryList> findAllByIdUser(int idUser);
}
