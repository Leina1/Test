/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.daysinmonth;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hooan
 */
public class DaysInMonthTest {
    
    public DaysInMonthTest() {
    }

    @Test
    public void testTC01(){
        int month = 1 , year = 2025;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=31;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC08(){
        int month = 4 , year = 2025;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=30;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC12(){
        int month = 2 , year = 2000;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=29;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC13(){
        int month = 2 , year = 2004;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=29;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC14(){
        int month = 2 , year = 1900;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=28;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC15(){
        int month = 2 , year = 2002;
        int result = DaysInMonth.getDaysInMonth(year, month);
        int ExpResult=28;
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC16(){
        int month = 0 , year = 2099;
        int result = DaysInMonth.getDaysInMonth(year, month);
        var ExpResult="Tháng ko hợp lệ";
        assertEquals(ExpResult,result);
    }
    @Test
    public void testTC17(){
        int month = 15 , year = 2002;
        int result = DaysInMonth.getDaysInMonth(year, month);
        var ExpResult="Tháng ko hợp lệ";
        assertEquals(ExpResult,result);
    }
}