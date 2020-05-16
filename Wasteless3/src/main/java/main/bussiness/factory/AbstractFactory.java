package main.bussiness.factory;

import main.bussiness.model.*;

public abstract class AbstractFactory {
    abstract ReportFactory getFactory(ReportType reportType);
}
