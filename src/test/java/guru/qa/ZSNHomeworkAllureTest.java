package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class ZSNHomeworkAllureTest {
    private String repository = "svetik0310/ZSNHomeWork14_2";
    private String exampleResult = "Allure";

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1500x840";
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    public void searchIssueTest() {
        open(Configuration.baseUrl);
        $(".header-search-input").setValue(repository).pressEnter();
        $(linkText(repository)).click();
        $("#issues-tab").click();
        $(withText(exampleResult)).shouldHave(Condition.exist);
    }

    @Test
    public void searchIssueLambdaTest() {
        step("Open page", () -> {
            open(Configuration.baseUrl);
        });
        step("Search repo", () -> {
            $(".header-search-input").setValue(repository).pressEnter();
        });
        step("Click by repo", () -> {
            $(linkText(repository)).click();
        });
        step("Go to Issues", () -> {
            $("#issues-tab").click();
        });
        step("Find our issue with text", () -> {
            $(withText(exampleResult)).shouldHave(Condition.exist);
        });
    }

    @Test
    public void searchIssueByStepClassTest() {
        AllureWebSteps steps = new AllureWebSteps();
        steps.openPage(Configuration.baseUrl)
                .searchRepo(repository)
                .clickByRepo(repository)
                .goToIssues()
                .findOurIssues(exampleResult);
    }
}
