/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.nhom12.lop02;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hooan
 */

public class WheyProductTest {
    
    static WheyProduct product;
    
    public WheyProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("========================================");
        System.out.println("=== BẮT ĐẦU TEST WHEY PRODUCT CLASS ===");
        System.out.println("========================================\n");
    }
    
    @Before
    public void setUp() {
        product = new WheyProduct("Whey Gold", 800.0, 50, "Optimum", 85.0);
        System.out.println(">> Setup: Khởi tạo WheyProduct mới");
    }
    
    @Test
    public void testTC_Constructor_01() {
        System.out.println("Test: TC_Constructor_01");
        
        WheyProduct p = new WheyProduct("Whey Gold", 800.0, 50, "Optimum", 85.0);
        
        String expName = "WHEY GOLD";
        String actName = p.getProductName();
        assertEquals(expName, actName);
        
        double expPrice = 800.0;
        double actPrice = p.getPrice();
        assertEquals(expPrice, actPrice, 0.01);
        
        int expStock = 50;
        int actStock = p.getStock();
        assertEquals(expStock, actStock);
        
        String expBrand = "Optimum";
        String actBrand = p.getBrand();
        assertEquals(expBrand, actBrand);
        
        double expProtein = 85.0;
        double actProtein = p.getProtein();
        assertEquals(expProtein, actProtein, 0.01);
        
        boolean expAvailable = true;
        boolean actAvailable = p.isAvailable();
        assertEquals(expAvailable, actAvailable);
        
        int expSold = 0;
        int actSold = p.getSoldQuantity();
        assertEquals(expSold, actSold);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_02() {
        System.out.println("Test: TC_Constructor_02");
        
        WheyProduct p = new WheyProduct("Whey Pro", -100, 50, "MyProtein", 80.0);
        
        double expResult = 0.0;
        double actResult = p.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_03() {
        System.out.println("Test: TC_Constructor_03");
        
        WheyProduct p = new WheyProduct("Mass Gainer", 600, -10, "BSN", 70.0);
        
        int expResult = 0;
        int actResult = p.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_04() {
        System.out.println("Test: TC_Constructor_04");
        
        WheyProduct p = new WheyProduct("  whey isolate  ", 900, 40, "  Dymatize  ", 90.0);
        
        String expName = "WHEY ISOLATE";
        String actName = p.getProductName();
        assertEquals(expName, actName);
        
        String expBrand = "Dymatize";
        String actBrand = p.getBrand();
        assertEquals(expBrand, actBrand);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_05() {
        System.out.println("Test: TC_Constructor_05");
        
        WheyProduct p = new WheyProduct("Test", -500, -20, "Brand", 75.0);
        
        double expPrice = 0.0;
        double actPrice = p.getPrice();
        assertEquals(expPrice, actPrice, 0.01);
        
        int expStock = 0;
        int actStock = p.getStock();
        assertEquals(expStock, actStock);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_06() {
        System.out.println("Test: TC_Constructor_06");
        
        WheyProduct p = new WheyProduct("Test", -500, -20, "Brand", -10);
        
        double expResult = 0.0;
        double actResult = p.getProtein();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Constructor_07() {
        System.out.println("Test: TC_Constructor_07");
        
        WheyProduct p = new WheyProduct("", -500, -20, "Brand", -10);
        
        String expResult = "Name is Empty";
        String actResult = p.getProductName();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Constructor_08() {
        System.out.println("Test: TC_Constructor_08");

        WheyProduct p = new WheyProduct("Test", 800, 50, "Brand", 150);

        double expResult = 100.0;
        double actResult = p.getProtein();
        assertEquals(expResult, actResult, 0.01);

        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Constructor_09() {
        System.out.println("Test: TC_Constructor_11");

        WheyProduct p = new WheyProduct("Test", 800, 50, "", 85);

        String expResult = "Brand is Empty";
        String actResult = p.getBrand();
        assertEquals(expResult, actResult);

        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Constructor_10() {
        System.out.println("Test: TC_Constructor_10");

        WheyProduct p = new WheyProduct("123", 800, 50, "", 85);

        String expResult = "Name is InValid";
        String actResult = p.getProductName();
        assertEquals(expResult, actResult);

        System.out.println("✓ PASSED\n");
    }

    @Test
    public void testTC_GetName_01() {
        System.out.println("Test: TC_GetName_01");
        
        WheyProduct p = new WheyProduct("whey gold", 800, 50, "Brand", 85);
        
        String expResult = "WHEY GOLD";
        String actResult = p.getProductName();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_GetName_02() {
        System.out.println("Test: TC_GetName_02");
        
        WheyProduct p = new WheyProduct("iso whey", 800, 50, "Brand", 85);
        
        String expResult = "ISO WHEY";
        String actResult = p.getProductName();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_GetName_03() {
        System.out.println("Test: TC_GetName_03");
        
        WheyProduct p = new WheyProduct("mass gainer", 800, 50, "Brand", 85);
        
        String expResult = "MASS GAINER";
        String actResult = p.getProductName();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_GetPrice_01() {
        System.out.println("Test: TC_GetPrice_01");
        
        WheyProduct p = new WheyProduct("Test", 799.996, 50, "Brand", 85);
        
        double expResult = 800.0;
        double actResult = p.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_GetPrice_02() {
        System.out.println("Test: TC_GetPrice_02");
        
        WheyProduct p = new WheyProduct("Test", 1000.0, 50, "Brand", 85);
        
        double expResult = 1000.0;
        double actResult = p.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_SetPrice_01() {
        System.out.println("Test: TC_SetPrice_01");
        
        product.setPrice(850.0);
        
        double expResult = 850.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTC_SetPrice_02() {
        System.out.println("Test: TC_SetPrice_02");
        
        product.setPrice(-500);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_SetStock_01() {
        System.out.println("Test: TC_SetStock_01");
        
        product.setStock(100);
        
        int expResult = 100;
        int actResult = product.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTC_SetStock_02() {
        System.out.println("Test: TC_SetStock_02");
        
        product.setStock(-50);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_SetProtein_01() {
        System.out.println("Test: TC_SetProtein_01");
        
        product.setProtein(85.0);
        
        double expResult = 85.0;
        double actResult = product.getProtein();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTC_SetProtein_02() {
        System.out.println("Test: TC_SetProtein_02");
        
        product.setProtein(-10);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTC_SetProtein_03() {
        System.out.println("Test: TC_SetProtein_03");
        
        product.setProtein(150);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_SetProtein_04() {
        System.out.println("Test: TC_SetProtein_04");
        
        product.setProtein(0);
        
        double expResult = 0.0;
        double actResult = product.getProtein();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_SetProtein_05() {
        System.out.println("Test: TC_SetProtein_05");
        
        product.setProtein(100);
        
        double expResult = 100.0;
        double actResult = product.getProtein();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Display_01() {
        System.out.println("Test: TC_Display_01");
        
        product.displayProductInfo();
        
        String expName = "WHEY GOLD";
        String actName = product.getProductName();
        assertEquals(expName, actName);
        
        String expBrand = "Optimum";
        String actBrand = product.getBrand();
        assertEquals(expBrand, actBrand);
        
        double expPrice = 800.0;
        double actPrice = product.getPrice();
        assertEquals(expPrice, actPrice, 0.01);
        
        int expStock = 50;
        int actStock = product.getStock();
        assertEquals(expStock, actStock);
        
        double expProtein = 85.0;
        double actProtein = product.getProtein();
        assertEquals(expProtein, actProtein, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdateAvail_01() {
        System.out.println("Test: TC_UpdateAvail_01");
        
        product.setStock(50);
        product.updateAvailability();
        
        boolean expResult = true;
        boolean actResult = product.isAvailable();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdateAvail_02() {
        System.out.println("Test: TC_UpdateAvail_02");
        
        product.setStock(0);
        product.updateAvailability();
        
        boolean expResult = false;
        boolean actResult = product.isAvailable();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
   
    
    @Test
    public void testTC_Restock_01() {
        System.out.println("Test: TC_Restock_01");
        
        product.setStock(20);
        product.restockProduct(30);
        
        int expStock = 50;
        int actStock = product.getStock();
        assertEquals(expStock, actStock);
        
        boolean expAvailable = true;
        boolean actAvailable = product.isAvailable();
        assertEquals(expAvailable, actAvailable);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Restock_02() {
        System.out.println("Test: TC_Restock_02");
        
        product.setStock(20);
        int stockBefore = product.getStock();
        product.restockProduct(0);
        
        int expResult = stockBefore;
        int actResult = product.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Restock_03() {
        System.out.println("Test: TC_Restock_03");
        
        product.setStock(20);
        int stockBefore = product.getStock();
        product.restockProduct(-10);
        
        int expResult = stockBefore;
        int actResult = product.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_01() {
        System.out.println("Test: TC_Discount_01");
        
        product.setPrice(1000);
        product.applyDiscount(10);
        
        double expResult = 900.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_02() {
        System.out.println("Test: TC_Discount_02");
        
        product.setPrice(800);
        product.applyDiscount(50);
        
        double expResult = 400.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_03() {
        System.out.println("Test: TC_Discount_03");
        
        product.setPrice(1000);
        double priceBefore = product.getPrice();
        product.applyDiscount(0);
        
        double expResult = priceBefore;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_04() {
        System.out.println("Test: TC_Discount_04");
        
        product.setPrice(1000);
        double priceBefore = product.getPrice();
        product.applyDiscount(101);
        
        double expResult = priceBefore;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_05() {
        System.out.println("Test: TC_Discount_05");
        
        product.setPrice(500);
        product.applyDiscount(100);
        
        double expResult = 0.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Discount_06() {
        System.out.println("Test: TC_Discount_06");
        
        product.setPrice(500);
        double priceBefore = product.getPrice();
        product.applyDiscount(-50);
        
        double expResult = priceBefore;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
     @Test
    public void testTC_Discount_07() {
        System.out.println("Test: TC_Discount_07");
        
        product.setPrice(1000);
        double priceBefore = product.getPrice();
        product.applyDiscount(200);
        
        double expResult = priceBefore;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    

    
    @Test
    public void testTC_HighQuality_01() {
        System.out.println("Test: TC_HighQuality_01");
        
        product.setProtein(85);
        product.setPrice(800);
        
        boolean expResult = true;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_HighQuality_02() {
        System.out.println("Test: TC_HighQuality_02");
        
        product.setProtein(85);
        product.setPrice(400);
        
        boolean expResult = false;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_HighQuality_03() {
        System.out.println("Test: TC_HighQuality_03");
        
        product.setProtein(70);
        product.setPrice(800);
        
        boolean expResult = false;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_HighQuality_04() {
        System.out.println("Test: TC_HighQuality_04");
        
        product.setProtein(70);
        product.setPrice(400);
        
        boolean expResult = false;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_HighQuality_05() {
        System.out.println("Test: TC_HighQuality_05");
        
        product.setProtein(80);
        product.setPrice(500);
        
        boolean expResult = true;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
     @Test
    public void testTC_HighQuality_06() {
        System.out.println("Test: TC_HighQuality_06");
        
        product.setProtein(150);
        product.setPrice(500);
        
        boolean expResult = false;
        boolean actResult = product.isHighQuality();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    
    
    @Test
    public void testTC_Rating_01() {
        System.out.println("Test: TC_Rating_01");
        
        product.setProtein(92);
        
        String expResult = "Excellent";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_02() {
        System.out.println("Test: TC_Rating_02");
        
        product.setProtein(85);
        
        String expResult = "Good";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_03() {
        System.out.println("Test: TC_Rating_03");
        
        product.setProtein(75);
        
        String expResult = "Average";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_04() {
        System.out.println("Test: TC_Rating_04");
        
        product.setProtein(65);
        
        String expResult = "Low";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_05() {
        System.out.println("Test: TC_Rating_05");
        
        product.setProtein(90);
        
        String expResult = "Excellent";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_06() {
        System.out.println("Test: TC_Rating_06");
        
        product.setProtein(80);
        
        String expResult = "Good";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_07() {
        System.out.println("Test: TC_Rating_07");
        
        product.setProtein(70);
        
        String expResult = "Average";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_08() {
        System.out.println("Test: TC_Rating_08");
        
        product.setProtein(0);
        
        String expResult = "Low";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_09() {
        System.out.println("Test: TC_Rating_09");
        
        product.setProtein(-50);
        
        String expResult = "Rating is InValid";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Rating_10() {
        System.out.println("Test: TC_Rating_10");
        
        product.setProtein(150);
        
        String expResult = "Rating is InValid";
        String actResult = product.getQualityRating();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_TotalValue_01() {
        System.out.println("Test: TC_TotalValue_01");
        
        product.setPrice(800);
        product.setStock(50);
        
        double expResult = 40000.0;
        double actResult = product.getTotalInventoryValue();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_TotalValue_02() {
        System.out.println("Test: TC_TotalValue_02");
        
        product.setPrice(800);
        product.setStock(0);
        
        double expResult = 0.0;
        double actResult = product.getTotalInventoryValue();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_TotalValue_03() {
        System.out.println("Test: TC_TotalValue_03");
        
        product.setPrice(1200.5);
        product.setStock(100);
        
        double expResult = 120050.0;
        double actResult = product.getTotalInventoryValue();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_TotalValue_04() {
        System.out.println("Test: TC_TotalValue_04");
        
        WheyProduct p = new WheyProduct("TEST", 800, -50, "Brand", 80);
        
        double expResult = 0.0;
        double actResult = p.getTotalInventoryValue();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_TotalValue_05() {
        System.out.println("Test: TC_TotalValue_05");
        
        WheyProduct p = new WheyProduct("TEST", -100, 50, "Brand", 85);
        
        boolean expResult = true;
        boolean actResult = p.getTotalInventoryValue() >= 0;
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_EligibleDisc_01() {
        System.out.println("Test: TC_EligibleDisc_01");
        
        product.setStock(150);
        product.setProtein(80);
        
        boolean expResult = true;
        boolean actResult = product.isEligibleForDiscount();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_EligibleDisc_02() {
        System.out.println("Test: TC_EligibleDisc_02");
        
        product.setStock(50);
        product.setProtein(80);
        
        boolean expResult = false;
        boolean actResult = product.isEligibleForDiscount();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_EligibleDisc_03() {
        System.out.println("Test: TC_EligibleDisc_03");
        
        product.setStock(50);
        product.setProtein(70);
        
        boolean expResult = true;
        boolean actResult = product.isEligibleForDiscount();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_EligibleDisc_04() {
        System.out.println("Test: TC_EligibleDisc_04");
        
        product.setStock(150);
        product.setProtein(70);
        
        boolean expResult = true;
        boolean actResult = product.isEligibleForDiscount();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_EligibleDisc_05() {
        System.out.println("Test: TC_EligibleDisc_05");
        
        product.setStock(100);
        product.setProtein(75);
        
        boolean expResult = false;
        boolean actResult = product.isEligibleForDiscount();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_01() throws Exception {
        System.out.println("Test: TC_Sale_01");
        
        product.setStock(50);
        product.updateAvailability();
        product.processSale(10);
        
        int expStock = 40;
        int actStock = product.getStock();
        assertEquals(expStock, actStock);
        
        int expSold = 10;
        int actSold = product.getSoldQuantity();
        assertEquals(expSold, actSold);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_02() {
        System.out.println("Test: TC_Sale_02");
        
        product.setStock(50);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.processSale(0);
        });
        
        String expResult = "Quantity must be greater than 0";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_03() {
        System.out.println("Test: TC_Sale_03");
        
        product.setStock(50);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.processSale(-5);
        });
        
        String expResult = "Quantity must be greater than 0";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_04() {
        System.out.println("Test: TC_Sale_04");
        
        product.setStock(50);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.processSale(100);
        });
        
        boolean expResult = true;
        boolean actResult = exception.getMessage().contains("Not enough stock. Available: 50");
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_05() {
        System.out.println("Test: TC_Sale_05");
        
        product.setStock(50);
        product.setStock(0);
        product.updateAvailability();
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.processSale(100);
        });
        
        String expResult = "Product is not available";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_06() throws Exception {
        System.out.println("Test: TC_Sale_06");
        
        product.setStock(50);
        product.processSale(50);
        
        int expStock = 0;
        int actStock = product.getStock();
        assertEquals(expStock, actStock);
        
        int expSold = 50;
        int actSold = product.getSoldQuantity();
        assertEquals(expSold, actSold);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Sale_07() {
        System.out.println("Test: TC_Sale_07");

        product.setStock(-50);
        product.updateAvailability();

        Exception exception = assertThrows(Exception.class, () -> {
            product.processSale(1);
        });

        String expResult = "Product is not available";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
    }
    @Test
    public void testTC_Order_01() throws Exception {
        System.out.println("Test: TC_Order_01");
        
        product.setPrice(800);
        product.setStock(50);
        product.placeOrder(5, 4000);
        
        int expResult = 45;
        int actResult = product.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Order_02() {
        System.out.println("Test: TC_Order_02");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(0, 1000);
        });
        
        String expResult = "Order quantity must be positive";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Order_03() {
        System.out.println("Test: TC_Order_03");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(-5, 1000);
        });
        
        String expResult = "Order quantity must be positive";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Order_04() {
        System.out.println("Test: TC_Order_04");
        
        product.setPrice(800);
        product.setStock(50);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(10, 5000);
        });
        
        boolean expResult = true;
        boolean actResult = exception.getMessage().contains("Insufficient payment. Need: $8000.0");
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Order_05() {
        System.out.println("Test: TC_Order_05");
        
        product.setStock(50);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(100, 80000);
        });
        
        boolean expResult = true;
        boolean actResult = exception.getMessage().contains("Cannot order 100 units. Stock: 50");
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Order_06() throws Exception {
        System.out.println("Test: TC_Order_07");
        product.setStock(0);
        product.setPrice(800);
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(10, 8000);
        });
        String expResult = "Out of stock";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testTC_Order_07() throws Exception {
        System.out.println("Test: TC_Order_07");
        
        product.setPrice(800);
        product.setStock(50);
        product.placeOrder(10, 8000);
        
        int expResult = 40;
        int actResult = product.getStock();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Order_08() {
        System.out.println("Test: TC_Order_09");
        product.setPrice(0);
        product.setStock(50);
        Exception exception = assertThrows(Exception.class, () -> {
            product.placeOrder(10, 0);
        });
        String expResult = "Invalid price";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
}
    
    @Test
    public void testTC_UpdatePrice_01() throws Exception {
        System.out.println("Test: TC_UpdatePrice_01");
        
        product.setPrice(800);
        product.updatePrice(900);
        
        double expResult = 900.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdatePrice_02() {
        System.out.println("Test: TC_UpdatePrice_02");
        
        product.setPrice(800);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.updatePrice(0);
        });
        
        String expResult = "Price must be positive";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdatePrice_03() {
        System.out.println("Test: TC_UpdatePrice_03");
        
        product.setPrice(800);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.updatePrice(-100);
        });
        
        String expResult = "Price must be positive";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdatePrice_04() {
        System.out.println("Test: TC_UpdatePrice_04");
        
        product.setPrice(800);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.updatePrice(2000);
        });
        
        boolean expResult = true;
        boolean actResult = exception.getMessage().contains("Price increase too high (max 200%)");
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdatePrice_05() throws Exception {
        System.out.println("Test: TC_UpdatePrice_05");
        
        product.setPrice(800);
        product.updatePrice(1600);
        
        double expResult = 1600.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_UpdatePrice_06() throws Exception {
        System.out.println("Test: TC_UpdatePrice_06");
        
        product.setPrice(800);
        product.updatePrice(500);
        
        double expResult = 500.0;
        double actResult = product.getPrice();
        assertEquals(expResult, actResult, 0.01);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_01() throws Exception {
        System.out.println("Test: TC_Expiry_01");
        
        product.setExpiryDate("2024-12-31");
        product.checkExpiry("2024-01-01");
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_02() {
        System.out.println("Test: TC_Expiry_02");
        
        product.setExpiryDate("2024-12-31");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2025-01-01");
        });
        
        String expResult = "Product has expired!";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_03() {
        System.out.println("Test: TC_Expiry_03");
        
        product.setExpiryDate(null);
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2024-01-01");
        });
        
        String expResult = "Expiry date not set";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_04() {
        System.out.println("Test: TC_Expiry_04");
        
        product.setExpiryDate("");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2024-01-01");
        });
        
        String expResult = "Expiry date not set";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_05() {
        System.out.println("Test: TC_Expiry_05");
        
        product.setExpiryDate("2024-12-31");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry(null);
        });
        
        String expResult = "Current date is invalid";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_06() {
        System.out.println("Test: TC_Expiry_06");
        
        product.setExpiryDate("2024-12-31");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("");
        });
        
        String expResult = "Current date is invalid";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_07() throws Exception {
        System.out.println("Test: TC_Expiry_07");
        
        product.setExpiryDate("2024-12-31");
        product.checkExpiry("2024-12-31");
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_08() {
        System.out.println("Test: TC_Expiry_08");
        
        product.setExpiryDate("2024-12-31");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2025-01-40");
        });
        
        String expResult = "Current date is invalid";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    
    @Test
    public void testTC_Expiry_09() {
        System.out.println("Test: TC_Expiry_09");
        
        product.setExpiryDate("2024-12-40");
        
        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2025-12-31");
        });
        
        String expResult = "expiry date is invalid";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
        
        System.out.println("✓ PASSED\n");
    }
    @Test
    public void testTC_Expiry_10() {
        System.out.println("Test: TC_Expiry_10");

        product.setExpiryDate("31-12-2024");

        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2025-01-01");
        });

        String expResult = "Invalid date format";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
    }
    @Test
    public void testTC_Expiry_11() {
        System.out.println("Test: TC_Expiry_12");

        product.setExpiryDate("2024-02-30");

        Exception exception = assertThrows(Exception.class, () -> {
            product.checkExpiry("2025-01-01");
        });

        String expResult = "expiry date is invalid";
        String actResult = exception.getMessage();
        assertEquals(expResult, actResult);
    }
    
    
    @After
    public void tearDown() {
        product = null;
        System.out.println(">> TearDown: Dọn dẹp object\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\n========================================");
        System.out.println("=== KẾT THÚC TEST WHEY PRODUCT CLASS ===");
        System.out.println("========================================");
    }
}