/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom12.lop02;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author hooan
 */
@RunWith(Parameterized.class)
public class WheyProductGetNameTest {
    private String inputName;
    private String expectedName;
    private WheyProduct product;

    public WheyProductGetNameTest(String inputName, String expectedName) {
        this.inputName = inputName;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"whey gold", "WHEY GOLD"},
            {"iso whey", "ISO WHEY"},
            {"mass gainer", "MASS GAINER"}
        });
    }

    @Before
    public void setUp() {
        product = new WheyProduct(inputName, 800, 50, "Brand", 85);
    }

    @Test
    public void testGetName() {
        assertEquals(expectedName, product.getProductName());
    }
}
