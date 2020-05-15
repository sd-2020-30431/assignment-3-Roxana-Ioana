package main.mediator.query;

import main.mediator.*;
import main.model.*;

public class GetReportQuery implements Request {

    private int idUser;
    private ReportType reportType;

    public GetReportQuery(int idUser, ReportType reportType) {
        this.idUser = idUser;
        this.reportType = reportType;
    }
}
