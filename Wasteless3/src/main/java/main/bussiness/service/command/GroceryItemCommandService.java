package main.bussiness.service.command;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class GroceryItemCommandService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemCommandService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public void deleteItem(int idItem) {
        groceryItemRepository.deleteByIdItem(idItem);
    }

    public void updateItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
    }
}
