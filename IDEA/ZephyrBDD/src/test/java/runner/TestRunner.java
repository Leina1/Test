package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "step",
        plugin = {
                "pretty",
                "json:target/cucumber.json" // Tạo file kết quả json tại thư mục target
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}