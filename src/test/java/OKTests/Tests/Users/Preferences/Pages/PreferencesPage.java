package OKTests.Tests.Users.Preferences.Pages;

import OKTests.Common.ProjectData;
import OKTests.Tests.Users.Preferences.Common.UserPreferencesConstants;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PreferencesPage {

    public void editPersonalInformation() {
        $x(UserPreferencesConstants.Selectors.PERSONAL_INFORMATION_PAGE).click();
    }

    public void setUserName(String name) {
        $(By.id(UserPreferencesConstants.Selectors.USER_NAME)).val(name);
    }

    public void saveChanges() {
        $(By.id(UserPreferencesConstants.Selectors.SAVE_CHANGES_BUTTON)).click();
    }

    public void setUserSurname(String surname) {
        $(By.id(UserPreferencesConstants.Selectors.USER_SURNAME)).val(surname);
    }

    public void setDayOfBirth(String day) {
        $(By.id(UserPreferencesConstants.Selectors.DAY_OF_BIRTH)).click();
        $x("//*[@id = 'field_bday']//option[text() = '" + day + "']").click();
    }

    public void setMonthOfBirth(String month) {
        $(By.id(UserPreferencesConstants.Selectors.MONTH_OF_BIRTH)).click();
        $x("//*[@id = 'field_bmonth']//option[text() = '" + month + "']").click();
    }

    public void setYearOfBirth(String year) {
        $(By.id(UserPreferencesConstants.Selectors.YEAR_OF_BIRTH)).click();
        $x("//*[@id = 'field_byear']//option[text() = '" + year + "']").click();
    }

    public void openPersonalDataPage() {
        $x(UserPreferencesConstants.Selectors.PERSONAL_DATA_PAGE).click();
    }

    public void changeGenderToWomen() {
        $(By.id(UserPreferencesConstants.Selectors.FEMALE_GENDER)).click();
    }

    public void changeGenderToMen() {
        $(By.id(UserPreferencesConstants.Selectors.MALE_GENDER)).click();
    }

    public void changeLivingCity(String city) {
        $(By.id(UserPreferencesConstants.Selectors.LIVING_CITY)).val(city);
    }

    public void changeOriginCity(String city) {
        $(By.id(UserPreferencesConstants.Selectors.ORIGIN_CITY)).val(city);
    }

    public void chooseCity(String city) {
        $x("//*[contains(@class,'ellip') and text() = '" + city + "']").click();
    }

    public void closeSettingsWindowsByCross() {
        $x(UserPreferencesConstants.Selectors.WINDOW_CROSS).click();
    }

    public void closeSettingsWindowByClickBehind(String xPathSelector, int x, int y) {
        actions().moveToElement($x(xPathSelector), x, y).click().perform();
    }

    public void closeSettingsWindowByCloseButton() {
        $(By.id(ProjectData.ProjectSelectors.CLOSE_BUTTON)).click();
    }

    public void countElementsByXpathOnPage(String element, int number) {
        $$x(element).shouldHave(CollectionCondition.size(number));
    }
}
