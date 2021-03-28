package OKTests.Tests.Users.Preferences.Tests;

import OKTests.Tests.Users.Preferences.Common.PersonalInformationBase;
import OKTests.Tests.Users.Preferences.Common.UserPreferencesConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInformationTests extends PersonalInformationBase {

    @Test(enabled = false)
    public void changeName_extraAttempts_errorDisplayed() {
        String name = "Петя";

        prefPage.setUserName(name);
        prefPage.saveChanges();

        Assert.assertEquals(getTextById(UserPreferencesConstants.Selectors.NOTIFY_PANEL_MSG), UserPreferencesConstants.Messages.CHANGING_NAME_ERROR);
    }

    @Test(enabled = false)
    public void changeSurname_extraAttempts_errorDisplayed() {
        String surname = "Иванов";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        Assert.assertEquals(getTextById(UserPreferencesConstants.Selectors.NOTIFY_PANEL_MSG), UserPreferencesConstants.Messages.CHANGING_NAME_ERROR);
    }

    @Test(enabled = false)
    public void changeName_closeErrorWindowByCross_windowCloses() {
        String surname = "Иванов";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        prefPage.closeSettingsWindowsByCross();
        xPathElementShouldNotExist(UserPreferencesConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test
    public void changeName_closeErrorWindowByButton_windowCloses() {
        String surname = "Иванов";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        prefPage.closeSettingsWindowByCloseButton();
        xPathElementShouldNotExist(UserPreferencesConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test(description = "bugfix task XXX-1234", enabled = false)
    public void changeName_closeByClickBehind_windowCloses() {
        String surname = "Иванов";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        prefPage.closeSettingsWindowByClickBehind(UserPreferencesConstants.Selectors.WINDOW_CROSS, 150, 150);

        xPathElementShouldNotExist(UserPreferencesConstants.Selectors.SETTINGS_WINDOW);
        xPathElementShouldExist(UserPreferencesConstants.Selectors.PERSONAL_INFORMATION_PAGE);
    }

    @Test
    public void changeName_emptyValue_errorDisplayed() {
        String name = "";

        prefPage.setUserName(name);
        prefPage.saveChanges();

        System.out.println(getTextByXpath(UserPreferencesConstants.Selectors.ERROR_FORM));
        Assert.assertEquals(getTextByXpath(UserPreferencesConstants.Selectors.ERROR_FORM), UserPreferencesConstants.Messages.EMPTY_NAME);
    }

    @Test
    public void changeSurname_emptyValue_errorDisplayed() {
        String surname = "";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        Assert.assertEquals(getTextByXpath(UserPreferencesConstants.Selectors.ERROR_FORM), UserPreferencesConstants.Messages.EMPTY_SURNAME);
    }


    @Test
    public void changeName_useSpecialSymbols_errorDisplayed() {
        String name = "$";

        prefPage.setUserSurname(name);
        prefPage.saveChanges();

        Assert.assertEquals(getTextByXpath(UserPreferencesConstants.Selectors.ERROR_FORM), UserPreferencesConstants.Messages.USE_ONLY_LETTERS);
    }

    @Test
    public void changeSurname_useSpecialSymbols_errorDisplayed() {
        String surname = "$";

        prefPage.setUserSurname(surname);
        prefPage.saveChanges();

        Assert.assertEquals(getTextByXpath(UserPreferencesConstants.Selectors.ERROR_FORM), UserPreferencesConstants.Messages.USE_ONLY_LETTERS);
    }

    @Test
    public void changeDOB_changeAllDates_dobDisplaysCorrectly() {
        String new_day = "23";
        String new_month = "июнь";
        String new_year = "2000";
        String old_day = "10";
        String old_month = "февраль";
        String old_year = "1988";

        prefPage.setDayOfBirth(new_day);
        prefPage.setMonthOfBirth(new_month);
        prefPage.setYearOfBirth(new_year);

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.AFTER_DOB_CHANGE, 3000);

        prefPage.openPersonalDataPage();

        prefPage.setDayOfBirth(old_day);
        prefPage.setMonthOfBirth(old_month);
        prefPage.setYearOfBirth(old_year);

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.BEFORE_DOB_CHANGE, 3000);
    }

    @Test
    public void changeDOB_changeDayToInvalid_dobDisplaysCorrectly() {
        String new_day = "день";

        prefPage.setDayOfBirth(new_day);
        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeMonthToInvalid_dobDisplaysCorrectly() {
        String new_month = "месяц";

        prefPage.setMonthOfBirth(new_month);
        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeYearToInvalid_dobDisplaysCorrectly() {
        String new_year = "год";

        prefPage.setYearOfBirth(new_year);
        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeYearTo1911_errorDisplays() {
        String new_year = "1911";

        prefPage.setYearOfBirth(new_year);
        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.LONG_LIVE_RECORD);
    }

    @Test
    public void changeDOB_changeDateTo29February_errorDisplays() {
        String new_day = "29";
        String new_month= "февраль";
        String new_year = "1989";

        prefPage.setDayOfBirth(new_day);
        prefPage.setMonthOfBirth(new_month);
        prefPage.setYearOfBirth(new_year);

        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeDateTo29FebruaryAndYearIsLeap_errorIsNotDisplayed() {
        String new_day = "29";
        String new_month= "февраль";
        String old_day = "10";

        prefPage.setDayOfBirth(new_day);
        prefPage.setMonthOfBirth(new_month);

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.LEAP_YEAR_NEW_DATE, 3000);

        prefPage.openPersonalDataPage();

        prefPage.setDayOfBirth(old_day);
        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.BEFORE_DOB_CHANGE, 3000);
    }

    @Test
    public void changeDOB_changeDateTo29FebruaryAndYearIsNotLeap_errorDisplays() {
        String new_day = "29";
        String new_year = "1989";

        prefPage.setDayOfBirth(new_day);
        prefPage.setYearOfBirth(new_year);

        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeDateTo30February_errorDisplays() {
        String new_day = "30";
        String new_month= "февраль";
        String new_year = "1989";

        prefPage.setDayOfBirth(new_day);
        prefPage.setMonthOfBirth(new_month);
        prefPage.setYearOfBirth(new_year);

        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeDOB_changeDateTo31February_errorDisplays() {
        String new_day = "31";
        String new_month= "февраль";
        String new_year = "1989";

        prefPage.setDayOfBirth(new_day);
        prefPage.setMonthOfBirth(new_month);
        prefPage.setYearOfBirth(new_year);

        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.DOB_INCORRECT);
    }

    @Test
    public void changeGender_changeToWomen_changedSuccessfully() {
        prefPage.changeGenderToWomen();

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.AFTER_GENDER_CHANGE, 3000);

        prefPage.openPersonalDataPage();
        prefPage.changeGenderToMen();

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.BEFORE_GENDER_CHANGE, 3000);
    }

    @Test
    public void setLivingPlace_emptyPlace_errorIsDisplayed() {
        String placeName = "";
        prefPage.changeLivingCity(placeName);

        prefPage.saveChanges();

        xPathElementShouldExist(UserPreferencesConstants.Selectors.LIVING_CITY_EMPTY);
    }

    @Test
    public void setLivingPlace_newValidPlace_errorIsDisplayed() {
        String newLivingCity = "Ярославль";
        String oldLivingCity = "Голицыно";
        String oldCityName = "г. Голицыно (Одинцовский район)";

        prefPage.changeLivingCity(newLivingCity);

        prefPage.chooseLivingCity(newLivingCity);

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.AFTER_LIVING_CITY_CHANGE, 3000);

        prefPage.openPersonalDataPage();
        prefPage.changeLivingCity(oldLivingCity);

        prefPage.chooseLivingCity(oldCityName);

        prefPage.saveChanges();

        waitForXpathElementContainText(UserPreferencesConstants.Selectors.SUMMARY_PERSONAL_INFORMATION, UserPreferencesConstants.Texts.BEFORE_LIVING_CITY_CHANGE, 3000);
    }

    @Test
    public void settingsWindow_closeWindowUsingCross_windowsCloses() {
        prefPage.closeSettingsWindowsByCross();

        xPathElementShouldNotExist(UserPreferencesConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test
    public void settingsWindows_closeByClickBehind_windowCloses() {
        prefPage.closeSettingsWindowByClickBehind(UserPreferencesConstants.Selectors.WINDOW_CROSS, 150, 150);

        xPathElementShouldNotExist(UserPreferencesConstants.Selectors.SETTINGS_WINDOW);
    }

}
