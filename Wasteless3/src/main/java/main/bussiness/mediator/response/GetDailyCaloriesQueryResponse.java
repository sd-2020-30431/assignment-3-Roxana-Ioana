package main.bussiness.mediator.response;

import main.bussiness.mediator.*;

public class GetDailyCaloriesQueryResponse implements Response {

    private int calories;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public GetDailyCaloriesQueryResponse(int calories) {
        this.calories = calories;
    }
}
