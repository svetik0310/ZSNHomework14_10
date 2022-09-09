package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureWebSteps {

    @Step("Open Page")
    public AllureWebSteps openPage(String url) {
        open(url);
        return this;
    }
    @Step("Search repo")
    public AllureWebSteps searchRepo(String data) {

        $(".header-search-input").setValue(data).pressEnter();
        return this;
    }

    @Step("Click by repo")
    public AllureWebSteps clickByRepo(String data){

        $(linkText(data)).click();
        return this;
    }

    @Step("Go to Issues")
    public AllureWebSteps goToIssues(){

        $("#issues-tab").click();
        return this;
    }
    @Step("Find our issue with text")
    public AllureWebSteps findOurIssues(String data){

        $(withText(data)).shouldHave(Condition.exist);
        return this;
    }
}
