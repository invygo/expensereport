package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseReportTest {
    @Test
    public void characterizationTest() {
        Date date = new Date();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ExpenseReport expenseReport = new ExpenseReport(date);
        expenseReport.printReport(List.of());
        String expectedOutput = "Expenses " + date + "\n" +
                "Meal expenses: 0\n" +
                "Total expenses: 0\n";

        Assertions.assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testPrintReportWithDifferentTypeOfExpense() {
        Date date = new Date();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ExpenseReport expenseReport = new ExpenseReport(date);

        List<Expense> expenseList = new ArrayList<>();

        Expense dinnerExpense = new Expense();
        dinnerExpense.type = ExpenseType.DINNER;
        dinnerExpense.amount = 1000;

        Expense breakfastExpense = new Expense();
        breakfastExpense.type = ExpenseType.BREAKFAST;
        breakfastExpense.amount = 1000;

        Expense carRentalExpense = new Expense();
        carRentalExpense.type = ExpenseType.CAR_RENTAL;
        carRentalExpense.amount = 1000;

        Expense expensiveBreakfastExpense = new Expense();
        expensiveBreakfastExpense.type = ExpenseType.BREAKFAST;
        expensiveBreakfastExpense.amount = 5500;

        Expense expensiveDinnerExpense = new Expense();
        expensiveDinnerExpense.type = ExpenseType.DINNER;
        expensiveDinnerExpense.amount = 5500;

        expenseList.add(dinnerExpense);
        expenseList.add(breakfastExpense);
        expenseList.add(carRentalExpense);
        expenseList.add(expensiveBreakfastExpense);
        expenseList.add(expensiveDinnerExpense);
        expenseReport.printReport(expenseList);

        String expectedOutput = "Expenses " + date + "\n" +
                "Dinner\t1000\t \n" +
                "Breakfast\t1000\t \n" +
                "Car Rental\t1000\t \n" +
                "Breakfast\t5500\tX\n" +
                "Dinner\t5500\tX\n" +
                "Meal expenses: 13000\n" +
                "Total expenses: 14000\n";
        Assertions.assertEquals(expectedOutput, out.toString());
    }
}
