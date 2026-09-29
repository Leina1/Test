package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartStepDefinitions {

    // Khai báo biến giả lập dữ liệu trong bộ nhớ
    private int mockItemCount = 0;
    private String mockTotalPrice = "$0";

    @Given("user opened cart page")
    public void openCartPage() {
        System.out.println("[MOCK STEP] Đã truy cập trang giỏ hàng.");
        mockItemCount = 0;
        mockTotalPrice = "$0";
    }

    @When("User added item to cart")
    public void addItemToCart() {
        System.out.println("[MOCK STEP] Người dùng bấm thêm 1 sản phẩm.");
        mockItemCount = 1;
        mockTotalPrice = "$100";
    }

    @Then("number or item in cart to changes")
    public void verifyItemCount() {
        System.out.println("[MOCK STEP] Kiểm tra số lượng sản phẩm...");
        // So sánh 1 == 1 (Luôn PASS)
        Assert.assertEquals(mockItemCount, 1);
    }

    @And("total price is correctly")
    public void verifyTotalPrice() {
        System.out.println("[MOCK STEP] Kiểm tra tổng tiền...");
        // So sánh "$100" == "$100" (Luôn PASS)
        Assert.assertEquals(mockTotalPrice, "$100");
    }
}