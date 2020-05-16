package main.bussiness.factory;

import main.bussiness.model.*;

public class WeeklyReportFactory extends ReportFactory {

    @Override
    public Report getReport(ReportType reportType) {
        return new WeeklyReport();
    }
}
