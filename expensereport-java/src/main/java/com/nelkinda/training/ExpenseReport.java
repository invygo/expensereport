package com.nelkinda.training;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    ExpenseType type;
    int amount;
}

public class ExpenseReport {

    private Date date = new Date();

    public ExpenseReport(Date date) {
        this.date = date;
    }

    public void printReport(List<Expense> expenses) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);

        for (Expense expense : expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount;
            }

            String expenseName = "";
            switch (expense.type) {
            case DINNER:
                expenseName = "Dinner";
                break;
            case BREAKFAST:
                expenseName = "Breakfast";
                break;
            case CAR_RENTAL:
                expenseName = "Car Rental";
                break;
            }

            String mealOverExpensesMarker;
            if (expense.type == ExpenseType.DINNER && expense.amount > 5000) {
                mealOverExpensesMarker = "X";
            } else if (expense.type == ExpenseType.BREAKFAST && expense.amount > 1000) {
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
