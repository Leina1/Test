import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class Count {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        File websiteFile = new File("src/test/resources/AutoProjectFinal/index.html");

        driver.get(websiteFile.toURI().toString());
        driver.findElement(By.linkText("Form Elements")).click();

        WebElement fistNameXpathInput = driver.findElement(By.xpath("//input[@name='firstName']"));

        //WebElement firstNameInput = driver.findElement(By.cssSelector("#first-name"));
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[id='first-name']"));
        WebElement lastNameInput = driver.findElement(By.cssSelector("#last-name"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement phoneInput = driver.findElement(By.cssSelector(".tel-input"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement websiteInput = driver.findElement(By.id("website-url"));
        WebElement dateInput = driver.findElement(By.id("birth-date"));


        firstNameInput.sendKeys("John");
        firstNameInput.clear();
        firstNameInput.sendKeys("Hoang");

        lastNameInput.sendKeys("Tran");
        emailInput.sendKeys("hoang.tran@example.com");
        phoneInput.sendKeys("1234567890");
        ageInput.sendKeys("22");
        websiteInput.sendKeys("https://www.example.com");
        dateInput.sendKeys("02/04/2005");

        List<WebElement> Buttons = driver.findElements(By.tagName("button"));
        System.out.println("Number of buttons: " + Buttons.size());
        for (WebElement button : Buttons) {
            System.out.println("Button text: " + button.getText());
        }

        List<WebElement> Links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + Links.size());
        for (WebElement link : Links) {
            System.out.println("Link text: " + link.getText());
        }

        //WebElement dropdown = driver.findElement(By.linkText("Dropdowns"));
//        WebElement dropdown = driver.findElement(By.partialLinkText("down"));
//        dropdown.click();
    }
}
