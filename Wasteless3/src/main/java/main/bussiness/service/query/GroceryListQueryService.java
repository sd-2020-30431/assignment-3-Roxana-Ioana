package main.bussiness.service.query;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GroceryListQueryService {

    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListQueryService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public ArrayList<GroceryList> selectAllLists(int idUser) {
        return groceryListRepository.findAllByIdUser(idUser);
    }

    public Optional<GroceryList> findListById(int idList) {
        return groceryListRepository.findById(idList);
    }
}
