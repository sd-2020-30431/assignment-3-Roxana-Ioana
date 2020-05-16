import { ReportInterface } from './reportInterface';

export class ReportDecorator implements ReportInterface{
    
    nbOfGroceryItems: number;
    groceryItems: import("../../grocery-items/item").GroceryItem[];
    nbOfEatenCalories: number;
    nbOfWastedCalories: number;
    wastedGroceryItems: import("../../grocery-items/item").GroceryItem[];
    colour: String;
    
    protected reportInterface: ReportInterface;

    constructor(reportInterface:ReportInterface)
    {
        this.reportInterface=reportInterface;

        this.groceryItems = reportInterface.groceryItems;
        this.nbOfEatenCalories = reportInterface.nbOfEatenCalories;
        this.nbOfGroceryItems = reportInterface.nbOfGroceryItems;
        this.wastedGroceryItems = reportInterface.wastedGroceryItems;
        this.nbOfWastedCalories = reportInterface.nbOfWastedCalories;
    }
 

}