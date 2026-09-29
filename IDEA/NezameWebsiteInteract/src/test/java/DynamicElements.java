import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

public class DynamicElements {
    @Test
    public void DynamicElementsTest() {
        WebDriver driver = new ChromeDriver();
        File website = new File("src/test/resources/AutoProjectFinal/index.html");
        driver.get(website.toURI().toString());
        WebDriverWait wate = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        driver.findElement(By.linkText("Dynamic Elements")).click();
        driver.findElement(By.cssSelector("#load-delayed-btn")).click();
        WebElement hidden = wate.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#delayed-element")));
        String text = hidden.getText();
        System.out.println(text);
    }
}
