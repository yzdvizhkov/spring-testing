package example;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.util.Arrays.asList;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloE2ESeleniumTest extends BaseTest {

    @LocalServerPort
    private int port;

    @Test
    public void helloPageHasTextHelloWorld() {
        open(String.format("http://localhost:%s/hello", port));
        SelenideElement body = $(Selectors.byCssSelector("body"));
        body.shouldHave(text("Hello World!"));
    }

    @Test
    public void searchStackOverflowWorksCorrectly() {
        open("https://selenide.org/");
        SelenideElement headerImage = $(Selectors.byCssSelector("header img"));
        SelenideElement newsLine = $(Selectors.byCssSelector(".news-line[style='display: block;']"));
        ElementsCollection menuPagesLinks = $$(Selectors.byCssSelector(".main-menu-pages a"));
        headerImage.shouldBe(Condition.visible);
        newsLine.shouldBe(Condition.visible);
        menuPagesLinks.shouldHave(CollectionCondition.exactTexts(asList("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")));
    }
}
