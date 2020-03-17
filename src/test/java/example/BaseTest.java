package example;

import com.codeborne.selenide.SelenideDriver;
import example.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    protected static final ThreadLocal<SelenideDriver> driver = new ThreadLocal<SelenideDriver>();


    @BeforeEach
    public void tearUp() {
        driver.set(WebDriverManager.getWebDriver());
    }

    @AfterEach
    public void tearDown() {
        driver.get().getWebDriver().quit();
    }
}
