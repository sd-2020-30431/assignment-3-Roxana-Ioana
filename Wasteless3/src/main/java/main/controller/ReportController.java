package main.controller;

import main.dto.*;
import main.mediator.*;
import main.mediator.handler.*;
import main.mediator.query.*;
import main.mediator.response.*;
import main.model.*;
import main.service.*;
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
    public ResponseEntity<Report> getReport(@PathVariable("idUser") int idUser, @PathVariable("type") String reportType) {
        //ReportDTO reportDTO = reportService.getReport(idUser, ReportType.valueOf(reportType));

        GetReportQuery request = new GetReportQuery(idUser, ReportType.valueOf(reportType));

        GetReportQueryHandler queryHandler = (GetReportQueryHandler)mediator.<GetReportQuery, GetReportQueryResponse>handle(request);
        GetReportQueryResponse response = queryHandler.handle(request);

        return new ResponseEntity<>(response.getReport(), HttpStatus.OK);
    }
}
