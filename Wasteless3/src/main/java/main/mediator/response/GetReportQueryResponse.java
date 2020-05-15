package main.mediator.response;

import main.mediator.*;
import main.model.*;

public class GetReportQueryResponse implements Response {

    private Report report;

    public GetReportQueryResponse(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
