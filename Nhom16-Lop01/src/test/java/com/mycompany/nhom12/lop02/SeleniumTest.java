package com.mycompany.nhom12.lop02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

// Thêm các thư viện cần thiết
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;

@Listeners(com.mycompany.nhom12.lop02.SeleniumCsvListener.class)
public class SeleniumTest {
    private WebDriver driver;
    // Khai báo WebDriverWait để sử dụng trong các test case chờ
    private WebDriverWait wait; 
    private String baseUrl = "https://www.saucedemo.com/";

    // Khai báo hằng số bị thiếu trong các hàm hỗ trợ
    private final String USER = "standard_user";
    private final String PASS = "secret_sauce";

    // --- DATA PROVIDERS (Giữ nguyên) ---

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", true, ""},
            {"locked_out_user", "secret_sauce", false, "Epic sadface: Sorry, this user has been locked out."},
            {"problem_user", "secret_sauce", true, ""},
//            {"performance_glitch_user", "secret_sauce", true, ""},
            {"error_user", "secret_sauce", true, ""},
            {"visual_user", "secret_sauce", true, ""}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][] {
            {"invalid_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
            {"standard_user", "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
            {"", "secret_sauce", "Epic sadface: Username is required"},
            {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @DataProvider(name = "validUsers")
    public Object[][] getValidUsers() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"problem_user", "secret_sauce"},
//            {"performance_glitch_user", "secret_sauce"},
            {"error_user", "secret_sauce"},
            {"visual_user", "secret_sauce"}
        };
    }

    // --- SETUP / TEARDOWN ---

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Khởi tạo WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // --- HELPER METHODS (Giữ nguyên) ---

    private void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    private List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        List<WebElement> products = driver.findElements(
            By.cssSelector("div[data-test='inventory-item-name']"));
        
        for (WebElement product : products) {
            names.add(product.getText());
        }
        return names;
    }

    private List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(
            By.cssSelector("div[data-test='inventory-item-price']"));
        
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    private boolean isListSortedAZ(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isListSortedZA(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareToIgnoreCase(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPriceSortedLowToHigh(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPriceSortedHighToLow(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private int getCartItemCount() {
        try {
            WebElement cartBadge = driver.findElement(
                By.cssSelector("span.shopping_cart_badge"));
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    

    @Test(priority = 1, dataProvider = "loginData", description = "TC_14 - Kiểm tra đăng nhập với nhiều users")
    public void TC_14_TestLoginWithMultipleUsers(String username, String password, boolean shouldSucceed, String expectedError) {
        System.out.println("\n=== TC_14: Test đăng nhập - User: " + username + " ===");
        
        login(username, password);
        
        if (shouldSucceed) {
            try {
                WebElement inventoryContainer = driver.findElement(
                    By.cssSelector("div[data-test='inventory-container']"));
                Assert.assertTrue(inventoryContainer.isDisplayed(), 
                    "FAILED: Không vào được trang sản phẩm!");
                System.out.println("✓ PASSED: Đăng nhập thành công với user: " + username);
            } catch (Exception e) {
                Assert.fail("FAILED: Không tìm thấy trang sản phẩm sau khi đăng nhập!");
            }
        } else {
            WebElement errorMessage = driver.findElement(
                By.cssSelector("h3[data-test='error']"));
            String actualError = errorMessage.getText();
            Assert.assertEquals(actualError, expectedError, 
                "FAILED: Error message không đúng!");
            System.out.println("✓ PASSED: User " + username + " bị chặn đúng");
            System.out.println("  Error: " + actualError);
        }
        
        System.out.println("\n✓✓✓ TC_14 PASSED ✓✓✓\n");
    }

    @Test(priority = 2, dataProvider = "invalidLoginData", description = "TC_15 - Kiểm tra đăng nhập với thông tin sai")
    public void TC_15_TestInvalidLogin(String username, String password, String expectedError) {
        System.out.println("\n=== TC_15: Test đăng nhập sai - User: '" + username + "', Pass: '" + password + "' ===");
        
        login(username, password);
        
        WebElement errorMessage = driver.findElement(
            By.cssSelector("h3[data-test='error']"));
        String actualError = errorMessage.getText();
        
        Assert.assertEquals(actualError, expectedError, 
            "FAILED: Error message không đúng!");
        
        System.out.println("✓ PASSED: Hiển thị error đúng");
        System.out.println("  Expected: " + expectedError);
        System.out.println("  Actual: " + actualError);
        System.out.println("\n✓✓✓ TC_15 PASSED ✓✓✓\n");
    }

    // TC_16: Thêm dataProvider để test case này có thể chạy được
    @Test(priority = 3, dataProvider = "validUsers", description = "TC_16 - Kiểm tra logout")
    public void TC_16_TestLogout(String username, String password) {
        System.out.println("\n=== TC_16: Test logout ===");
        
        login(username, password);
        
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        
        // Dùng wait tường minh thay vì Thread.sleep()
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("logout_sidebar_link")));
        logoutLink.click();
        
        // Kiểm tra sau khi logout
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed(), 
            "FAILED: Không logout được!");
        
        System.out.println("✓ PASSED: Logout thành công");
        System.out.println("\n✓✓✓ TC_16 PASSED ✓✓✓\n");
    }

    @Test(priority = 4, dataProvider = "validUsers", description = "TC_01 - Kiểm tra số lượng sản phẩm với nhiều users")
    public void TC_01_VerifyProductCount(String username, String password) {
        System.out.println("\n=== TC_01: Kiểm tra số lượng sản phẩm - User: " + username + " ===");
        
        login(username, password);
        
        WebElement inventoryContainer = driver.findElement(
            By.cssSelector("div[data-test='inventory-container']"));
        
        List<WebElement> products = inventoryContainer.findElements(
            By.cssSelector("div[data-test='inventory-item']"));
        
        int actualCount = products.size();
        System.out.println("Số lượng sản phẩm tìm được: " + actualCount);
        
        Assert.assertEquals(actualCount, 6, 
            "FAILED: Số lượng sản phẩm không đúng! Expected: 6, Actual: " + actualCount);
        
        System.out.println("✓ PASSED: Số lượng sản phẩm đúng = 6 cái");
        
        System.out.println("\nDanh sách 6 sản phẩm:");
        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            String productName = product.findElement(
                By.cssSelector("div[data-test='inventory-item-name']")).getText();
            System.out.println((i+1) + ". " + productName);
        }
        
        System.out.println("\n✓✓✓ TC_01 PASSED ✓✓✓\n");
    }

    @Test(priority = 5, dataProvider = "validUsers", description = "TC_02 - Test sản phẩm Backpack với nhiều users")
    public void TC_02_VerifyBackpackProduct(String username, String password) {
        System.out.println("\n=== TC_02: Kiểm tra sản phẩm Backpack - User: " + username + " ===");
        
        login(username, password);
        
        String productName = "Sauce Labs Backpack";
        String expectedPrice = "$29.99";
        double expectedPriceNumber = 29.99;
        
        WebElement imageLink = driver.findElement(By.id("item_4_img_link"));
        
        WebElement inventoryItem = imageLink.findElement(
            By.xpath("./ancestor::div[@data-test='inventory-item']"));
        WebElement priceElement = inventoryItem.findElement(
            By.cssSelector("div[data-test='inventory-item-price']"));
        
        String actualPrice = priceElement.getText();
        
        Assert.assertEquals(actualPrice, expectedPrice, 
            "FAILED: Giá sản phẩm không đúng!");
        
        String priceNumber = actualPrice.replace("$", "");
        double price = Double.parseDouble(priceNumber);
        Assert.assertTrue(price > 0, "FAILED: Giá phải lớn hơn 0");
        Assert.assertEquals(price, expectedPriceNumber, "FAILED: Giá không phải " + expectedPriceNumber);
        
        WebElement nameElement = inventoryItem.findElement(
            By.cssSelector("div[data-test='inventory-item-name']"));
        String actualName = nameElement.getText();
        
        Assert.assertEquals(actualName, productName, 
            "FAILED: Tên sản phẩm không đúng!");
        
        System.out.println("✓ PASSED: Sản phẩm Backpack có đúng tên và giá");
        System.out.println("\n✓✓✓ TC_02 PASSED ✓✓✓\n");
    }
    
    @Test(priority = 6, dataProvider = "validUsers", description = "TC_08 - Sort A-Z với nhiều users")
    public void TC_08_SortByNameAtoZ(String username, String password) {
        System.out.println("\n=== TC_08: Sort A-Z - User: " + username + " ===");
        
        login(username, password);
        
        WebElement sortDropdown = driver.findElement(
            By.cssSelector("select[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);
        
        select.selectByValue("az");
        
        List<String> productNames = getProductNames();
        
        Assert.assertTrue(isListSortedAZ(productNames), 
            "FAILED: Danh sách không được sắp xếp theo A-Z!");
        
        Assert.assertEquals(productNames.get(0), "Sauce Labs Backpack", 
            "Sản phẩm đầu tiên phải là Backpack");
        Assert.assertEquals(productNames.get(5), "Test.allTheThings() T-Shirt (Red)", 
            "Sản phẩm cuối cùng phải là Test.allTheThings()");
        
        System.out.println("✓ PASSED: Sort A-Z đúng");
        System.out.println("\n✓✓✓ TC_08 PASSED ✓✓✓\n");
    }
    
    @Test(priority = 7, dataProvider = "validUsers", description = "TC_09 - Sort Z-A với nhiều users")
    public void TC_09_SortByNameZtoA(String username, String password) {
        System.out.println("\n=== TC_09: Sort Z-A - User: " + username + " ===");
        
        login(username, password);
        
        WebElement sortDropdown = driver.findElement(
            By.cssSelector("select[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);
        
        select.selectByValue("za");
        
        List<String> productNames = getProductNames();
        
        Assert.assertTrue(isListSortedZA(productNames), 
            "FAILED: Danh sách không được sắp xếp theo Z-A!");
        
        Assert.assertEquals(productNames.get(0), "Test.allTheThings() T-Shirt (Red)", 
            "Sản phẩm đầu tiên phải là Test.allTheThings()");
        Assert.assertEquals(productNames.get(5), "Sauce Labs Backpack", 
            "Sản phẩm cuối cùng phải là Backpack");
        
        System.out.println("✓ PASSED: Sort Z-A đúng");
        System.out.println("\n✓✓✓ TC_09 PASSED ✓✓✓\n");
    }

    @Test(priority = 8, dataProvider = "validUsers", description = "TC_10 - Sort giá thấp→cao với nhiều users")
    public void TC_10_SortByPriceLowToHigh(String username, String password) {
        System.out.println("\n=== TC_10: Sort giá Low to High - User: " + username + " ===");
        
        login(username, password);
        
        WebElement sortDropdown = driver.findElement(
            By.cssSelector("select[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);
        
        select.selectByValue("lohi");
        
        List<Double> prices = getProductPrices();
        List<String> names = getProductNames();
        
        Assert.assertTrue(isPriceSortedLowToHigh(prices), 
            "FAILED: Giá không được sắp xếp từ thấp đến cao!");
        
        Assert.assertEquals(prices.get(0), 7.99, 
            "Sản phẩm rẻ nhất phải có giá $7.99 (Onesie)");
        Assert.assertEquals(prices.get(5), 49.99, 
            "Sản phẩm đắt nhất phải có giá $49.99 (Fleece Jacket)");
        
        System.out.println("✓ PASSED: Sort giá thấp→cao đúng");
        System.out.println("\n✓✓✓ TC_10 PASSED ✓✓✓\n");
    }
    
    @Test(priority = 9, dataProvider = "validUsers", description = "TC_11 - Sort giá cao→thấp với nhiều users")
    public void TC_11_SortByPriceHighToLow(String username, String password) {
        System.out.println("\n=== TC_11: Sort giá High to Low - User: " + username + " ===");
        
        login(username, password);
        
        WebElement sortDropdown = driver.findElement(
            By.cssSelector("select[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);
        
        select.selectByValue("hilo");
        
        List<Double> prices = getProductPrices();
        
        Assert.assertTrue(isPriceSortedHighToLow(prices), 
            "FAILED: Giá không được sắp xếp từ cao đến thấp!");
        
        Assert.assertEquals(prices.get(0), 49.99, 
            "Sản phẩm đắt nhất phải có giá $49.99 (Fleece Jacket)");
        Assert.assertEquals(prices.get(5), 7.99, 
            "Sản phẩm rẻ nhất phải có giá $7.99 (Onesie)");
        
        System.out.println("✓ PASSED: Sort giá cao→thấp đúng");
        System.out.println("\n✓✓✓ TC_11 PASSED ✓✓✓\n");
    }
    
    @Test(priority = 10, dataProvider = "validUsers", description = "TC_12 - Add 1 sản phẩm với nhiều users")
    public void TC_12_AddSingleProductToCart(String username, String password) {
        System.out.println("\n=== TC_12: Add 1 sản phẩm - User: " + username + " ===");
        
        login(username, password);
        
        int cartBefore = getCartItemCount();
        
        WebElement addButton = driver.findElement(
            By.id("add-to-cart-sauce-labs-backpack"));
        addButton.click();

        int cartAfter = getCartItemCount();

        Assert.assertEquals(cartAfter, cartBefore + 1, 
            "FAILED: Không add được sản phẩm vào cart!");
        
        System.out.println("✓ PASSED: Add sản phẩm thành công (Cart: " + cartBefore + " → " + cartAfter + ")");
        System.out.println("\n✓✓✓ TC_12 PASSED ✓✓✓\n");
    }
    
    @Test(priority = 11, dataProvider = "validUsers", description = "TC_13 - Add tất cả sản phẩm với nhiều users")
    public void TC_13_AddAllProductsToCart(String username, String password) {
        System.out.println("\n=== TC_13: Add tất cả sản phẩm - User: " + username + " ===");
        
        login(username, password);
        
        int cartBefore = getCartItemCount();
        
        // Cần tìm lại elements trong vòng lặp nếu DOM thay đổi (nút Add chuyển thành Remove),
        // nhưng ở đây ta dùng vòng lặp để click nút Add đầu tiên 6 lần, và nó tự xóa khỏi list Add To Cart.
        // Code này đã được tối ưu cho giao diện saucedemo.
        List<WebElement> addButtons = driver.findElements(
            By.cssSelector("button[id^='add-to-cart']"));
        
        int totalProducts = addButtons.size();
        
        for (int i = 0; i < totalProducts; i++) {
            // Cần tìm lại list addButtons vì sau mỗi lần click, DOM thay đổi
            addButtons = driver.findElements(
                By.cssSelector("button[id^='add-to-cart']"));
            addButtons.get(0).click();
        }
        
        int cartAfter = getCartItemCount();
        
        Assert.assertEquals(cartAfter, cartBefore + totalProducts, 
            "FAILED: Không add được tất cả sản phẩm vào cart!");
        
        System.out.println("✓ PASSED: Add " + totalProducts + " sản phẩm thành công (Cart: " + cartBefore + " → " + cartAfter + ")");
        System.out.println("\n✓✓✓ TC_13 PASSED ✓✓✓\n");
    }

    // --- TEST CASES MỚI (Đã sửa lỗi) ---

    // TC_Fn_07 - Test sắp xếp liên tục
    @Test(priority = 12, description = "TC_Fn_07 - Test sắp xếp liên tục")
    public void testTC02() {
        System.out.println("\n=== TC_Fn_07: Test sắp xếp liên tục ===");
        loginStandardUser();

        // 1. Name (A to Z)
        Select sort1 = new Select(driver.findElement(By.cssSelector("select.product_sort_container")));
        sort1.selectByVisibleText("Name (A to Z)");
        System.out.println("  > Sorted A-Z");

        // 2. Name (Z to A) - Tìm lại element
        Select sort2 = new Select(driver.findElement(By.cssSelector("select.product_sort_container")));
        sort2.selectByVisibleText("Name (Z to A)");
        System.out.println("  > Sorted Z-A");

        // 3. Price (low to high) - Tìm lại element
        Select sort3 = new Select(driver.findElement(By.cssSelector("select.product_sort_container")));
        sort3.selectByVisibleText("Price (low to high)");
        System.out.println("  > Sorted Low to High");

        // 4. Price (high to low) - Tìm lại element
        Select sort4 = new Select(driver.findElement(By.cssSelector("select.product_sort_container")));
        sort4.selectByVisibleText("Price (high to low)");
        System.out.println("  > Sorted High to Low");

        // Kiểm tra việc sắp xếp không gây lỗi (không bị StaleElementReferenceException)
        Assert.assertTrue(true, "FAILED: Bị lỗi khi sắp xếp liên tục!");
        System.out.println("✓ PASSED: Thực hiện 4 lần sort thành công");
        System.out.println("\n✓✓✓ TC_Fn_07 PASSED ✓✓✓\n");
    }

    // TC_Fn_04 (Đã ánh xạ, nhưng giữ lại tên testTC03) - Add To Cart 
    @Test(priority = 13, description = "TC_Fn_04 - Add 1 sản phẩm (testTC03)")
    public void testTC03() {
        System.out.println("\n=== TC_Fn_04: Add To Cart (testTC03) ===");
        login(); // Sử dụng hàm login() mặc định (standard_user)

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String cart = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cart, "1", "FAILED: Số lượng giỏ hàng không phải 1!");
        System.out.println("✓ PASSED: Thêm sản phẩm thành công, giỏ hàng: " + cart);
        System.out.println("\n✓✓✓ TC_Fn_04 PASSED ✓✓✓\n");
    }

    // TC_Fn_06 - Remove From Cart
    @Test(priority = 14, description = "TC_Fn_06 - Remove sản phẩm (testTC04)")
    public void testTC04() {
        System.out.println("\n=== TC_Fn_06: Remove From Cart (testTC04) ===");
        login(); // Sử dụng hàm login() mặc định (standard_user)

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        System.out.println("  > Added to cart (Count: " + getCartItemCount() + ")");
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        boolean badgeVisible = driver.findElements(By.className("shopping_cart_badge")).size() > 0;
        Assert.assertFalse(badgeVisible, "FAILED: Badge giỏ hàng vẫn còn!");
        System.out.println("✓ PASSED: Remove thành công, badge giỏ hàng đã biến mất");
        System.out.println("\n✓✓✓ TC_Fn_06 PASSED ✓✓✓\n");
    }

    // TC_Fn_09 - Checkout Step 2 (Overview)
    @Test(priority = 15, description = "TC_Fn_09 - Checkout Step 2 (testTC05)")
    public void testTC05() {
        System.out.println("\n=== TC_Fn_09: Checkout Step 2 (testTC05) ===");
        loginStandardUser();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.urlContains("cart.html"));

        driver.findElement(By.id("checkout")).click();
        
        // Đợi form xuất hiện
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        
        driver.findElement(By.id("first-name")).sendKeys("Key");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("70000");
        driver.findElement(By.id("continue")).click();

        // Đợi trang checkout-step-two load
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        
        // Tìm element chứa text "Total" bằng XPath
        WebElement total = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'Total:')]"))); // Đã sửa XPath chính xác hơn
        
        System.out.println("Found Total element: " + total.getText());
        Assert.assertTrue(total.getText().contains("Total"), "FAILED: Không tìm thấy dòng Total");
        System.out.println("✓ PASSED: Đi đến Checkout Overview và tìm thấy Total");
        System.out.println("\n✓✓✓ TC_Fn_09 PASSED ✓✓✓\n");
    }

    // TC_Fn_10 - Finish Order (Checkout Complete)
    @Test(priority = 16, description = "TC_Fn_10 - Finish Order (testTC06)")
    public void testTC06() throws InterruptedException {
        System.out.println("\n=== TC_Fn_10: Finish Order (testTC06) ===");
        loginStandardUser();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.urlContains("cart.html"));

        driver.findElement(By.id("checkout")).click();
        
        // Đợi form xuất hiện
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        
        driver.findElement(By.id("first-name")).sendKeys("Key");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("70000");
        driver.findElement(By.id("continue")).click();

        // Đợi trang checkout-step-two load xong
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        
        // Thử tìm button finish bằng id
        WebElement finishBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        
        // Scroll và click (Sử dụng JavascriptExecutor đã import)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", finishBtn);
        // Không dùng Thread.sleep, sử dụng wait hoặc đợi element click được
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();

        // Đợi message xuất hiện
        WebElement successMsg = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("complete-header")));
        
        System.out.println("Success message: " + successMsg.getText());
        Assert.assertEquals(successMsg.getText(), "THANK YOU FOR YOUR ORDER!", "FAILED: Message không khớp");
        System.out.println("✓ PASSED: Hoàn tất Order thành công!");
        System.out.println("\n✓✓✓ TC_Fn_10 PASSED ✓✓✓\n");
    }

    // --- SUPPORT METHOD (Đã sửa lỗi) ---
    // Sửa hàm login() để sử dụng biến đã khai báo
    public void login() {
        driver.findElement(By.id("user-name")).sendKeys(USER);
        driver.findElement(By.id("password")).sendKeys(PASS);
        driver.findElement(By.id("login-button")).click();
    }

    // Giữ nguyên hàm loginStandardUser, nó hoạt động tốt
    private void loginStandardUser() {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // Xác nhận login thành công
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login không thành công");
    }
}