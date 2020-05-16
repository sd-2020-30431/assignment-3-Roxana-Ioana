import main.bussiness.mediator.*;
import main.bussiness.mediator.command.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.command.*;
import main.presentation.controller.*;
import main.presentation.dto.*;
import main.presentation.mapper.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GroceryItemControllerTest {

    @Mock
    private GroceryItemCommandService groceryItemService;

    @Mock
    private ApplicationContext applicationContext;

    private GroceryItemController groceryItemController;

    private GroceryItemMapper groceryItemMapper;
    
    private Mediator mediator;

    @Before
    public void setUp() {
        mediator = new Mediator();
        groceryItemController = new GroceryItemController(mediator);
    }

    public GroceryItemControllerTest() {
        this.groceryItemMapper = new GroceryItemMapper();
    }

    @Test
    public void addGroceryItem() {
        int idList = 1;

        GroceryItemDTO groceryItemDTO = new GroceryItemDTO(idList, "paine");
        GroceryItem groceryItem = groceryItemMapper.convertToGroceryItem(groceryItemDTO);

        groceryItem.setIdItem(1);
        
        CreateGroceryItemCommand groceryItemCommand = new CreateGroceryItemCommand(groceryItem);
        CreateGroceryItemCommandHandler handler = new CreateGroceryItemCommandHandler(groceryItemService);
        CreateGroceryItemCommandResponse response = new CreateGroceryItemCommandResponse(groceryItem);

        mediator.setApplicationContext(applicationContext);
        when(mediator.<CreateGroceryItemCommand, CreateGroceryItemCommandResponse>getHandler(groceryItemCommand)).thenReturn(handler);
        when(groceryItemService.addGroceryItem(groceryItem)).thenReturn(groceryItem);
        when(handler.handle(groceryItemCommand)).thenReturn(response);
                
        Integer idItem = groceryItemController.addGroceryItem(groceryItemDTO).getBody();
        
        System.out.println(idItem);
        assertEquals((Integer) groceryItem.getIdItem(), idItem);
    }
}
