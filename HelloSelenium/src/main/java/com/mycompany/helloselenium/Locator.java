/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helloselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author hooan
 */
public class Locator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/test/newtours/index.php");
        
        WebElement user = driver.findElement(By.name("userName"));
        
        user.sendKeys("hello baby");
        
        driver.findElement(By.name("password")).sendKeys("aaaa");
        Thread.sleep(3000);
       
        driver.findElement(By.linkText("Flights")).click();
        
                
        driver.findElement(By.cssSelector("input[name='tripType'][value='roundtrip']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='tripType' and @value='roundtrip']")).click();
        driver.quit();
    }
}
