package main.bussiness.service.query;

import main.bussiness.model.*;
import main.dao.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class GroceryItemQueryService {

    private final GroceryItemRepository groceryItemRepository;
    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryItemQueryService(GroceryItemRepository groceryItemRepository, GroceryListRepository groceryListRepository) {
        this.groceryItemRepository = groceryItemRepository;
        this.groceryListRepository = groceryListRepository;
    }

    public List<GroceryItem> findByIdList(int idList) {
        return groceryItemRepository.findByIdList(idList);
    }

    public List<GroceryItem> getGroceryItemsWhichExpire(int idUser) {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> groceryItemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        return getItemsWhichExpireNext5Days(items);
    }

    private List<GroceryItem> getItemsWhichExpireNext5Days(List<GroceryItem> items) {
        LocalDate date = LocalDate.now().plusDays(5);
        return items.stream().filter(groceryItem -> groceryItem.getExpirationDate().isBefore(date) && groceryItem.getConsumptionDate() == null).collect(Collectors.toList());
    }
}
