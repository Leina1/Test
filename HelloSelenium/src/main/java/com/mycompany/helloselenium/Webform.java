package com.mycompany.helloselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webform {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement textAreas = driver.findElement(By.name("my-textarea"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        
        textBox.sendKeys("Huy Hoàng");
        password.sendKeys("abc");
        Thread.sleep(2000);
        
        textAreas.sendKeys("Testing ....");
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("input[type='checkbox'][id='my-check-1']")).click();
        driver.findElement(By.cssSelector("input[type='checkbox'][id='my-check-2']")).click();
        driver.findElement(By.cssSelector("input[type='radio'][id='my-radio-2']")).click();
        
        driver.findElement(By.id("my-check-1")).click();
        
        Thread.sleep(2000);
        submitButton.click();
        
        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
