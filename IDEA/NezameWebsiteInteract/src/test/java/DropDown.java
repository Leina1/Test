import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class DropDown {
    @Test
    public void dropdown(){
        WebDriver driver = new ChromeDriver();
        File website = new File("src/test/resources/AutoProjectFinal/index.html");
        driver.get(website.toURI().toString());
        driver.findElement(By.linkText("Dropdowns")).click();
        Select select = new Select(driver.findElement(By.cssSelector("#country-select")));
        select.selectByIndex(1);
        select.selectByValue("eg");
        select.selectByVisibleText("Canada");
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        Select skillselect = new Select(driver.findElement(By.cssSelector("#skills-select")));
        skillselect.selectByIndex(1);
        skillselect.selectByIndex(2);
        skillselect.selectByIndex(3);

        WebElement CustomDropDown = driver.findElement(By.cssSelector("#custom-lang-dropdown"));
        CustomDropDown.click();
        driver.findElement(By.cssSelector(("#option-javascript"))).click();

    }

    @Test
    public void radioButton() {
        WebDriver driver = new ChromeDriver();
        File website = new File("src/test/resources/AutoProjectFinal/index.html");
        driver.get(website.toURI().toString());
        driver.findElement(By.linkText("Checkboxes & Radio")).click();
        WebElement termcheckbox = driver.findElement(By.cssSelector("#terms-checkbox"));
//        termcheckbox.click();
        if (!termcheckbox.isSelected()) {
            termcheckbox.click();
        }
        driver.findElement(By.cssSelector("#select-all-btn")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input.tool-checkbox"));
        for(WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                System.out.println("Checkbox is not selected: " + checkbox.getAttribute("id"));
            }
        }
        driver.findElement(By.cssSelector("#lang-python")).click();
        driver.findElement(By.cssSelector("#test-integration")).click();

    }
}
