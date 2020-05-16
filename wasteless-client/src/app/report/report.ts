import { GroceryItem } from '../grocery-items/item';
import { ReportInterface } from './decorator/reportInterface';

export class Report implements ReportInterface{

    public nbOfGroceryItems:number;
    public groceryItems: GroceryItem[];
    public nbOfEatenCalories:number;
    public nbOfWastedCalories:number;
    public wastedGroceryItems:GroceryItem[];
    public colour: String;
}
