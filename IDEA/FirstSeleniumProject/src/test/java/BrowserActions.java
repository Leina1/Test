import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserActions {
    WebDriver driver;

    @Test
    public void firstTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        navigation("https://www.youtube.com");
        getCurrentUrl();
        maximize();
        setposition();
        setDimension();
        getTitle();
//        getPageSource();
        getwindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        getwindowHandle();
        closeBrowser();
    }

    public void navigation(String url) {
        driver.navigate().to(url);
    }

    public void navigationBack() {
        driver.navigate().back();
    }

    public void navigationForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void setposition() {
        driver.manage().window().setPosition(new Point(100, 6));
    }

    public void setDimension() {
        driver.manage().window().setSize(new Dimension(390, 844));
    }

    public void getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }

    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    public void getPageSource() {
        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);
    }

    public void getwindowHandle() {
        String windowHandle = driver.getWindowHandle();
        System.out.println("Window Handle: " + windowHandle);
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("Tất cả Window Handles: " + allHandles);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
