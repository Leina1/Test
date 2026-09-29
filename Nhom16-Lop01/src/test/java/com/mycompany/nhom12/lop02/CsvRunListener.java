/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom12.lop02;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author hooan
 */
public class CsvRunListener extends RunListener {

    private FileWriter writer;

    @Override
    public void testRunStarted(Description description) throws Exception {
        writer = new FileWriter("JUnitTestResult.csv");
        writer.write("TestName,Status,Message\n");
    }

    @Override
    public void testFinished(Description description) throws Exception {
        writer.write(description.getMethodName() + ",PASSED,\n");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        writer.write(failure.getDescription().getMethodName() 
                + ",FAILED," 
                + failure.getMessage().replace(",", ";") + "\n");
    }

    @Override
    public void testRunFinished(org.junit.runner.Result result) throws Exception {
        writer.close();
        System.out.println("CSV Export Completed: JUnitTestResult.csv");
    }
}
