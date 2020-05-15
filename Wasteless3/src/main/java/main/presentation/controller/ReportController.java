package main.presentation.controller;

import main.bussiness.mediator.*;
import main.bussiness.mediator.handler.*;
import main.bussiness.mediator.query.*;
import main.bussiness.mediator.response.*;
import main.bussiness.model.*;
import main.presentation.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/report")
public class ReportController {

    private final Mediator mediator;

    @Autowired
    public ReportController(Mediator mediator) {
        this.mediator = mediator;
    }

    @RequestMapping(value = "/{idUser}/{type}", method = RequestMethod.GET)
    public ResponseEntity<ReportDTO> getReport(@PathVariable("idUser") int idUser, @PathVariable("type") String reportType) {
        GetReportQuery request = new GetReportQuery(idUser, ReportType.valueOf(reportType));

        GetReportQueryHandler queryHandler = (GetReportQueryHandler) mediator.<GetReportQuery, GetReportQueryResponse>handle(request);
        GetReportQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getReport(), HttpStatus.OK);
    }
}
