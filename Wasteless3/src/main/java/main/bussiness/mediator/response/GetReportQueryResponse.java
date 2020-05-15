package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.presentation.dto.*;

public class GetReportQueryResponse implements Response {

    private ReportDTO report;

    public GetReportQueryResponse(ReportDTO report) {
        this.report = report;
    }

    public ReportDTO getReport() {
        return report;
    }

    public void setReport(ReportDTO report) {
        this.report = report;
    }
}
