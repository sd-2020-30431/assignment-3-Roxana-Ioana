import { GroceryItem } from 'src/app/grocery-items/item';

export interface ReportInterface{
    
    nbOfGroceryItems:number;
    groceryItems: GroceryItem[];
    nbOfEatenCalories:number;
    nbOfWastedCalories:number;
    wastedGroceryItems:GroceryItem[];
    colour:String;
}