package main.bussiness.mediator;

import main.bussiness.mediator.command.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import org.springframework.beans.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final Map<Class<? extends Request>, Class<? extends Handler<? extends Request, ? extends Response>>> handlerMap;

    public Mediator() {
        handlerMap = new HashMap<>();

        handlerMap.put(CreateGoalCommand.class, CreateGoalCommandHandler.class);
        handlerMap.put(CreateGroceryListCommand.class, CreateGroceryListCommandHandler.class);
        handlerMap.put(CreateGroceryItemCommand.class, CreateGroceryItemCommandHandler.class);
        handlerMap.put(CreateUserCommand.class, CreateUserCommandHandler.class);
        handlerMap.put(DeleteGroceryItemCommand.class, DeleteGroceryItemCommandHandler.class);
        handlerMap.put(DeleteGroceryListCommand.class, DeleteGroceryListCommandHandler.class);
        handlerMap.put(FindGoalQuery.class, FindGoalQueryHandler.class);
        handlerMap.put(FindGroceryItemsQuery.class, FindGroceryItemsQueryHandler.class);
        handlerMap.put(FindGroceryListsQuery.class, FindGroceryListsQueryHandler.class);
        handlerMap.put(FindUserQuery.class, FindUserQueryHandler.class);
        handlerMap.put(GetDailyCaloriesQuery.class, GetDailyCaloriesQueryHandler.class);
        handlerMap.put(GetExpireGroceryItemsQuery.class, GetExpireGroceryItemsQueryHandler.class);
        handlerMap.put(GetReportQuery.class, GetReportQueryHandler.class);
        handlerMap.put(UpdateGroceryItemCommand.class, UpdateGroceryItemCommandHandler.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T extends Request, R extends Response> Handler<T, R> getHandler(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMap.get(request.getClass());
        return (Handler<T, R>) applicationContext.getBean(handlerType);
    }
}
