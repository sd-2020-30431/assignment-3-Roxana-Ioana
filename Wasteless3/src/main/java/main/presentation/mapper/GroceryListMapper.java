package main.presentation.mapper;

import main.bussiness.model.*;
import main.presentation.dto.*;

public class GroceryListMapper {

    public GroceryList convertToGroceryList(GroceryListDTO groceryListDTO) {
        GroceryList groceryList = new GroceryList();

        groceryList.setIdUser(groceryListDTO.getIdUser());
        groceryList.setIdList(groceryListDTO.getIdList());
        groceryList.setName(groceryListDTO.getName());

        return groceryList;
    }

    public GroceryListDTO convertToDTO(GroceryList groceryList) {
        GroceryListDTO groceryListDTO = new GroceryListDTO();

        groceryListDTO.setIdUser(groceryList.getIdUser());
        groceryListDTO.setIdList(groceryList.getIdList());
        groceryListDTO.setName(groceryList.getName());

        return groceryListDTO;
    }
}
