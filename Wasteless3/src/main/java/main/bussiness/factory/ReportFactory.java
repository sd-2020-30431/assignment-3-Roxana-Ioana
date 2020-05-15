package main.bussiness.factory;

import main.bussiness.model.*;

public abstract class ReportFactory {
    public abstract Report getReport(ReportType reportType);
}
