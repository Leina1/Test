import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class Alerts {
    @Test
    public void alertTest() {
        WebDriver driver = new ChromeDriver();
        File website = new File("src/test/resources/AutoProjectFinal/index.html");
        driver.get(website.toURI().toString());
        driver.findElement(By.linkText("Alerts & Popups")).click();
        driver.findElement(By.cssSelector("#trigger-alert-btn")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("#trigger-confirm-btn")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector("#trigger-prompt-btn")).click();
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("#show-error-alert-btn")).click();
        driver.findElement(By.cssSelector("#open-modal-btn")).click();
        driver.findElement(By.cssSelector("#modal-input")).sendKeys("Tao dep trai");
        driver.findElement(By.cssSelector("#modal-confirm-btn")).click();
        driver.findElement(By.cssSelector("#open-danger-modal-btn")).click();
        driver.findElement(By.cssSelector("#danger-modal-confirm-btn")).click();
    }
}
