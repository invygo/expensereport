package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ExpenseReportTest {
    @Test
    public void characterizationTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ExpenseReport expenseReport = new ExpenseReport();
        expenseReport.printReport(List.of());
        String expectedOutput = "Expenses Wed Aug 07 17:24:19 GST 2024\n" +
                "Meal expenses: 0\n" +
                "Total expenses: 0\n";

        Assertions.assertEquals(expectedOutput, out.toString());
    }
}
