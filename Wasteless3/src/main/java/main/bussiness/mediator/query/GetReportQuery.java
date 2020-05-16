package main.bussiness.mediator.query;

import main.bussiness.mediator.*;
import main.bussiness.model.*;

public class GetReportQuery implements Request {

    private int idUser;
    private ReportType reportType;

    public GetReportQuery(int idUser, ReportType reportType) {
        this.idUser = idUser;
        this.reportType = reportType;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }
}
