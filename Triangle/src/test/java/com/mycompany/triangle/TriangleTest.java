/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.triangle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hooan
 */
public class TriangleTest {
    
    public TriangleTest() {
    }

    
    @Test
    public void testTC01() {
          // a + b <= c → không phải tam giác
        int result = Triangle.getTriangleType(1, 2, 3);
        int expResult = -1;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC02() {
          // Tam giác đều
        int result = Triangle.getTriangleType(3, 3, 3);
        int expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC03() {
          // Tam giác vuông (Pythagoras)
        int result = Triangle.getTriangleType(3, 4, 5);
        int expResult = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC04() {
          // Tam giác vuông cân
        int result = Triangle.getTriangleType(1, 1, (int)Math.round(Math.sqrt(2)));
        int expResult = 2;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC05() {
          // Tam giác cân
        int result = Triangle.getTriangleType(5,5,6);
        int expResult = 3;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC06() {
          // Tam giác thường
        int result = Triangle.getTriangleType(4,5,6);
        int expResult = 4;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC07() {
          // Trường hợp cạnh bằng 0 (không phải tam giác)
        int result = Triangle.getTriangleType(0,5,5);
        int expResult = -1;
        assertEquals(expResult, result);
    }
    @Test
    public void testTC08() {
          // Trường hợp cạnh âm (dữ liệu không hợp lệ)
        int result = Triangle.getTriangleType(-1,9,5);
        int expResult = -1;
        assertEquals(expResult, result);
    }
}
