import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Tables {
    @Test
    public void tableTest() {
        WebDriver driver = new ChromeDriver();
        File website = new File("src/test/resources/AutoProjectFinal/index.html");
        driver.get(website.toURI().toString());
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Tables")).click();
        List<WebElement> rows = driver.findElements(By.cssSelector("#static-table-body tr"));
        System.out.println("Number of rows in the table: " + rows.size());

        List<WebElement> columns = driver.findElements(By.cssSelector("#static-table-header-row th"));
        System.out.println("Number of columns in the table: " + columns.size());
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String studentName = cells.get(1).getText();
            if (studentName.equals("David Chen")) {
                String role = cells.get(3).getText();
                System.out.println("Role of David Chen: " + role);
                System.out.println(studentName);
                break;
            }
        }
        WebElement sortscore = driver.findElement(By.cssSelector("#searchable-table th[data-col='3']"));
        sortscore.click();

        WebElement row1 = driver.findElement(By.cssSelector("#searchable-table-body tr:nth-child(1) td:nth-child(4)"));
        WebElement row2 = driver.findElement(By.cssSelector("#searchable-table-body tr:nth-child(2) td:nth-child(4)"));
        System.out.println("Row 1 score: " + row1.getText());
        System.out.println("Row 2 score: " + row2.getText());
        int row1Score = Integer.parseInt(row1.getText());
        int row2Score = Integer.parseInt(row2.getText());
        if (row1Score > row2Score) {
            System.out.println("Row 1 has a higher score than Row 2.");
        } else if (row1Score < row2Score) {
            System.out.println("Row 2 has a higher score than Row 1.");
        } else {
            System.out.println("Row 1 and Row 2 have the same score.");
        }

    }

 }
