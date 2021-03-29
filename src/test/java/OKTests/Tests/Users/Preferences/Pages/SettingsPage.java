package OKTests.Tests.Users.Preferences.Pages;

import OKTests.Common.ProjectData;
import OKTests.Common.TestBase;
import OKTests.Tests.Users.Preferences.Common.UserSettingsConstants;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SettingsPage extends TestBase {

    public void editPersonalInformation() {
        $x(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_PAGE).click();
    }

    public void setUserName(String name) {
        $(By.id(UserSettingsConstants.Selectors.USER_NAME)).val(name);
    }

    public void saveChanges() {
        $(By.id(UserSettingsConstants.Selectors.SAVE_CHANGES_BUTTON)).click();
    }

    public void setUserSurname(String surname) {
        $(By.id(UserSettingsConstants.Selectors.USER_SURNAME)).val(surname);
    }

    public void setDayOfBirth(String day) {
        $(By.id(UserSettingsConstants.Selectors.DAY_OF_BIRTH)).click();
        $x(String.format(UserSettingsConstants.Selectors.DAY_OF_BIRTH_DROPDOWN, day)).click();
    }

    public void setMonthOfBirth(String month) {
        $(By.id(UserSettingsConstants.Selectors.MONTH_OF_BIRTH)).click();
        $x(String.format(UserSettingsConstants.Selectors.MONTH_OF_BIRTH_DROPDOWN, month)).click();
    }

    public void setYearOfBirth(String year) {
        $(By.id(UserSettingsConstants.Selectors.YEAR_OF_BIRTH)).click();
        $x(String.format(UserSettingsConstants.Selectors.YEAR_OF_BIRTH_DROPDOWN, year)).click();
    }

    public void openPersonalDataPage() {
        $x(UserSettingsConstants.Selectors.PERSONAL_DATA_PAGE).click();
    }

    public void changeGenderToWomen() {
        $(By.id(UserSettingsConstants.Selectors.FEMALE_GENDER)).click();
    }

    public void changeGenderToMen() {
        $(By.id(UserSettingsConstants.Selectors.MALE_GENDER)).click();
    }

    public void changeLivingCity(String city) {
        $(By.id(UserSettingsConstants.Selectors.LIVING_CITY)).val(city);
    }

    public void changeOriginCity(String city) {
        $(By.id(UserSettingsConstants.Selectors.ORIGIN_CITY)).val(city);
    }

    public void chooseCity(String city) {
        $x(String.format(UserSettingsConstants.Selectors.CHOOSE_CITY, city)).click();
    }

    public void closeSettingsWindowsByCross() {
        $x(UserSettingsConstants.Selectors.WINDOW_CROSS).click();
    }

    public void closeSettingsWindowByClickBehind(String xPathSelector, int x, int y) {
        actions().moveToElement($x(xPathSelector), x, y).click().perform();
    }

    public void closeSettingsWindowByCloseButton() {
        $(By.id(ProjectData.Selectors.CLOSE_BUTTON)).click();
    }

    public void countElementsByXpathOnPage(String element, int number) {
        $$x(element).shouldHave(CollectionCondition.size(number));
    }

    public void setDefaultUserSettings() {
        openPersonalDataPage();
        setUserName(ProjectData.UserData.USER_NAME);
        setUserSurname(ProjectData.UserData.USER_SURNAME);
        setDayOfBirth(ProjectData.UserData.DAY_OF_BIRTH);
        setMonthOfBirth(ProjectData.UserData.MONTH_OF_BIRTH);
        setYearOfBirth(ProjectData.UserData.YEAR_OF_BIRTH);
        changeGenderToMen();
        changeLivingCity(ProjectData.UserData.OLD_CITY_NAME);
        chooseCity(ProjectData.UserData.OLD_CITY_NAME);
        clearTextFromElementById(UserSettingsConstants.Selectors.ORIGIN_CITY);
        saveChanges();

        waitForXpathElementContainText(UserSettingsConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserSettingsConstants.Summary.ORIGIN_TEXT, 3000);
    }
}
