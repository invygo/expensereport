package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
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
    public void testPrintReport_WithDifferentTypeOfExpense() {
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

        expenseList.add(dinnerExpense);
        expenseList.add(breakfastExpense);
        expenseReport.printReport(expenseList);

        String expectedOutput = "Expenses " + date + "\n" +
                "Dinner\t1000\t \n" +
                "Breakfast\t1000\t \n" +
                "Meal expenses: 2000\n" +
                "Total expenses: 2000\n";
        Assertions.assertEquals(expectedOutput, out.toString());
    }
}
