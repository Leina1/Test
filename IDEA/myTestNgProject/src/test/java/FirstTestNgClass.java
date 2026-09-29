import net.bytebuddy.TypeCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNgClass {
    WebDriver driver;

    @BeforeTest
    public void prepareTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test(priority = 0)
    public void openBrowser() {
        System.out.println("This is my first TestNG test.");
        driver.navigate().to("https://www.youtube.com/");
    }
    @Test(priority = 1)
    public void sigin(){
        System.out.println("This is my first TestNG test.");
    }
    @Test(priority = 2)
    public void add(){
        System.out.println("This is my first TestNG test.");
    }
    @Test(priority = 3)
    public void logout(){
        System.out.println("This is my first TestNG test.");
    }

}
