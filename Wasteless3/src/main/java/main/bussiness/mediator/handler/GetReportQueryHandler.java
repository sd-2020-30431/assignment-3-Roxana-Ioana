package main.bussiness.mediator.handler;

import main.bussiness.mediator.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.service.query.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class GetReportQueryHandler implements Handler<GetReportQuery, GetReportQueryResponse> {

    private final ReportQueryService queryService;

    @Autowired
    public GetReportQueryHandler(ReportQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public GetReportQueryResponse handle(GetReportQuery q) {
        return new GetReportQueryResponse(queryService.getReport(q.getIdUser(), q.getReportType()));
    }
}
