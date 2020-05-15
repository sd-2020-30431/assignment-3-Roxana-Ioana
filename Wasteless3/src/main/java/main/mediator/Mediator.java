package main.mediator;

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
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public <T extends Request, R extends Response> Handler<T, R> handle(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMap.get(request.getClass());
        return (Handler<T, R>) applicationContext.getBean(handlerType);
    }
}
