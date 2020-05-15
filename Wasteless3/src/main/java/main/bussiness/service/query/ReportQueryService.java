package main.bussiness.service.query;

import main.bussiness.factory.*;
import main.bussiness.model.*;
import main.dao.repository.*;
import main.presentation.dto.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ReportQueryService {

    private GroceryListRepository groceryListRepository;
    private GroceryItemRepository groceryItemRepository;

    public ReportQueryService(GroceryListRepository groceryListRepository,
                              GroceryItemRepository groceryItemRepository) {
        this.groceryListRepository = groceryListRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public ReportDTO getReport(int idUser, ReportType reportType) {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> groceryItemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        return new FactoryProvider().getFactory(reportType).getReport(reportType).sendReport(items);
    }
}
