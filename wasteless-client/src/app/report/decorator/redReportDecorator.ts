import { ReportDecorator } from './reportDecorator';
import { ReportInterface } from './reportInterface';

export class RedReportDecorator extends ReportDecorator{

    constructor(reportInterface:ReportInterface)
    {
        super(reportInterface);
        this.colour = this.getReportColour();
    }

    getReportColour()
    {
        return "red";
    }
    
}