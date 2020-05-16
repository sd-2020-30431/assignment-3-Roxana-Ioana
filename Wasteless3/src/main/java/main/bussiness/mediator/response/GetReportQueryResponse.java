package main.bussiness.mediator.response;

import main.bussiness.mediator.*;
import main.presentation.dto.*;

public class GetReportQueryResponse implements Response {

    private ReportDTO reportDtoDecorated;

    public GetReportQueryResponse(ReportDTO report) {
        this.reportDtoDecorated = report;
    }

    public ReportDTO getReport() {
        return reportDtoDecorated;
    }

    public void setReport(ReportDTO report) {
        this.reportDtoDecorated = report;
    }
}
