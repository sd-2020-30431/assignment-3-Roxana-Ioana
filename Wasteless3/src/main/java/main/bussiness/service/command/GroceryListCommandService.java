package main.bussiness.service.command;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class GroceryListCommandService {

    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListCommandService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public GroceryList createNewList(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public void deleteList(int idList) {
        groceryListRepository.deleteById(idList);
    }
}

