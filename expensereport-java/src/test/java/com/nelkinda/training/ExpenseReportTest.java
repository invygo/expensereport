package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

public class ExpenseReportTest {
    @Test
    public void charectarizationTest() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ExpenseReport expenseReport = new ExpenseReport();
        expenseReport.printReport(List.of());

        String expectedOutput = "Expenses " + new Date() + "\n" +
                                "Meal expenses: 0\n"+
                                "Total expenses: 0\n";

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
