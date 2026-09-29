/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom12.lop02;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 *
 * @author hooan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        WheyProductTest.class
})
public class WheyProductTestSuite {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CsvRunListener()); // gắn CSV listener
        Result result = core.run(WheyProductTest.class);
    }
}
