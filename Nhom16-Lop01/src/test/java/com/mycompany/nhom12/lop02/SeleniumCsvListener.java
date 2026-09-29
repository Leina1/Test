package com.mycompany.nhom12.lop02;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumCsvListener implements ITestListener {

    private static final String CSV_FILE = "SeleniumTestResult.csv";

    @Override
    public void onStart(ITestContext context) {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            writer.append("Test Name,Status,Execution Time,Error Message\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeResult(ITestResult result, String status) {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {

            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            String error = "";
            if (result.getThrowable() != null) {
                error = result.getThrowable().getMessage().replace(",", " "); // tránh lỗi CSV
            }

            writer.append(result.getName()).append(",");
            writer.append(status).append(",");
            writer.append(time).append(",");
            writer.append(error).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        writeResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        writeResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        writeResult(result, "SKIPPED");
    }
}
