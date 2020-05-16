package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.bussiness.service.query.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class FindUserQueryHandler implements Handler<FindUserQuery, FindUserQueryResponse> {

    private final UserQueryService queryService;

    @Autowired
    public FindUserQueryHandler(UserQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public FindUserQueryResponse handle(FindUserQuery q) {
        Optional<User> user = queryService.findUser(q.getUsername(), q.getPassword());
        return user.map(FindUserQueryResponse::new).orElseGet(() -> new FindUserQueryResponse(null));
    }
}
