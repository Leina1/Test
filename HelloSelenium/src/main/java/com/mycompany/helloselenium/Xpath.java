/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.helloselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author hooan
 */
public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/login.html");
        Thread.sleep(3000);
        WebElement user = driver.findElement(By.id("email"));
        user.sendKeys("abc");
        Thread.sleep(1000);
        WebElement passworđ = driver.findElement(By.id("passwd"));
        passworđ.sendKeys("12345678890");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        
        driver.navigate().back();
        Thread.sleep(1000);
        
        user.clear();
        passworđ.clear();
        user.sendKeys("abc");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        
        
        driver.navigate().back();
        Thread.sleep(1000);
        passworđ.sendKeys("12345678890");
         Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
}
