package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    public void testPrintReportWithOneExpense() {
        Date date = new Date();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ExpenseReport expenseReport = new ExpenseReport(date);
        Expense expense = new Expense();
        expense.type = ExpenseType.DINNER;
        expense.amount = 1000;

        expenseReport.printReport(List.of(expense));

        String expectedOutput = "Expenses " + date + "\n" +
                "Dinner\t1000\t \n" +
                "Meal expenses: 1000\n" +
                "Total expenses: 1000\n";
        Assertions.assertEquals(expectedOutput, out.toString());

    }
}
