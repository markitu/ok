package OKTests.Common;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected void loginAsUser(String username, String password) {
        loginInput(username);
        passwordInput(password);
        pressLoginButton();
    }

    protected void loginInput(String username) {
        $(ProjectData.ProjectSelectors.LOGIN_INPUT).val(username);
    }

    protected void passwordInput(String password) {
        $(ProjectData.ProjectSelectors.PASSWORD_INPUT).val(password);
    }

    protected void pressLoginButton() {
        $x(ProjectData.ProjectSelectors.SUBMIT_BUTTON).click();
    }

    protected void openSettingsPage() {
//        $x(ProjectData.ProjectSelectors.MENU_FRAME).click();
//        $x(ProjectData.ProjectSelectors.SETTING_PAGE).click();
        open("https://ok.ru/settings");
    }

    protected static String getTextById(String locator) {
        return $(By.id(locator)).getText();
    }

    protected static String getTextByCSS(String locator) {
        return $(locator).getText();
    }

    protected static String getTextByXpath(String locator) {
        return $x(locator).getText();
    }

    protected void xPathElementShouldExist(String element) {
        $x(element).should(Condition.exist);
    }

    protected void xPathElementShouldNotExist(String element) {
        $x(element).shouldNot(Condition.exist);
    }

    protected void CSSElementShouldExist(String element) {
        $(element).should(Condition.exist);
    }

    protected void waitForXpathElementContainText(String element, String text, int milliseconds) {
        $x(element).waitUntil(Condition.exactText(text), milliseconds);
    }

    protected void clearTextFromElementById(String element) {
        $(By.id(element)).clear();
    }

    protected void elementByXpathShouldBeVisible(String element) {
        $x(element).shouldBe(Condition.visible);
    }

}
