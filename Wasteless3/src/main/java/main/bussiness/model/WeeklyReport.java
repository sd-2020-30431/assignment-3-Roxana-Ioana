package main.bussiness.model;

import main.presentation.dto.*;

import java.util.*;

public class WeeklyReport extends Report {

    public ReportDTO sendReport(List<GroceryItem> groceryItems) {
        return generateReport(getGroceryItems(groceryItems, 7));
    }
}
