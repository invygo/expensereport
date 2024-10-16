package com.nelkinda.training;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL;

    boolean isMeal() {
        return isDinner() || isBreakfast();
    }

    boolean isBreakfast() {
        return this == BREAKFAST;
    }

    boolean isDinner() {
        return this == DINNER;
    }
}

public class ExpenseReport {

    private final Date date;

    public ExpenseReport(Date date) {
        this.date = date;
    }

    public void printReport(List<Expense> expenses) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);

        for (Expense expense : expenses) {
            ExpenseType type = expense.type;
            if (type.isMeal()) {
                mealExpenses += expense.amount;
            }

            String expenseName = switch (type) {
                case DINNER -> "Dinner";
                case BREAKFAST -> "Breakfast";
                case CAR_RENTAL -> "Car Rental";
            };

            String mealOverExpensesMarker;
            if (type == ExpenseType.DINNER && expense.amount > 5000) {
                mealOverExpensesMarker = "X";
            } else if (type == ExpenseType.BREAKFAST && expense.amount > 1000) {
                mealOverExpensesMarker = "X";
            } else {
                mealOverExpensesMarker = " ";
            }

            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

}
