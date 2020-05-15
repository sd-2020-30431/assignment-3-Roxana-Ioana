package main.bussiness.factory;

import main.bussiness.model.*;

public class MonthlyReportFactory extends ReportFactory {

    @Override
    public Report getReport(ReportType reportType) {
        return new MonthlyReport();
    }
}
