package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

class FakeExpenseReport extends ExpenseReport {
    private final Date date;

    public FakeExpenseReport(Date date) {
        this.date = date;
    }

    @Override
    public Long DateNow() {
        return this.date.getTime();
    }
}

public class ExpenseReportTest {
    @Test
    public void characterizationTest() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Date date = new Date();
        ExpenseReport expenseReport = new FakeExpenseReport(date);

        expenseReport.printReport(List.of());

        String expectedOutput = "Expenses " + date.getTime() + "\n" +
                                "Meal expenses: 0\n"+
                                "Total expenses: 0\n";

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
