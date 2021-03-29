package OKTests.Tests.Users.Settings.Tests;

import OKTests.Tests.Users.Settings.Common.PersonalInformationBase;
import OKTests.Tests.Users.Settings.Common.UserSettingsConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInformationTests extends PersonalInformationBase {

    @Test(enabled = false)
    public void changeName_extraAttempts_errorDisplayed() {
        String name = "Петя";

        settingsPage.setUserName(name);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextById(UserSettingsConstants.Selectors.NOTIFY_PANEL_MSG), UserSettingsConstants.Messages.CHANGING_NAME_ERROR);
    }

    @Test(enabled = false)
    public void changeName_newName_newNameSaves() {
        String new_name = "Дмитрий";

        try {
            settingsPage.setUserName(new_name);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_NAME_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test(enabled = false)
    public void changeSurname_newSurname_newSurnameSaves() {
        String new_surname = "Стольный";

        try {
            settingsPage.setUserSurname(new_surname);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_SURNAME_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test(enabled = false)
    public void changeSurname_extraAttempts_errorDisplayed() {
        String surname = "Иванов";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextById(UserSettingsConstants.Selectors.NOTIFY_PANEL_MSG), UserSettingsConstants.Messages.CHANGING_NAME_ERROR);
    }

    @Test(enabled = false)
    public void changeName_maxLengthReached_saveOnly16Symbols() {
        String new_name = "аааааааааааааааар";

        try {
            settingsPage.setUserName(new_name);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_NAME_MAX_LENGTH_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test(enabled = false)
    public void changeSurname_maxLengthReached_saveOnly24Symbols() {
        String new_surname = "аааааааааааааааааааааааащ";

        try {
            settingsPage.setUserSurname(new_surname);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_SURNAME_MAX_LENGTH_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test(enabled = false)
    public void changeName_closeErrorWindowByCross_windowCloses() {
        String surname = "Иванов";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();
        settingsPage.closeSettingsWindowsByCross();

        xPathElementShouldNotExist(UserSettingsConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test(enabled = false)
    public void changeName_closeErrorWindowByButton_windowCloses() {
        String surname = "Иванов";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();
        settingsPage.closeSettingsWindowByCloseButton();
        xPathElementShouldNotExist(UserSettingsConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test(description = "bugfix task XXX-1234", enabled = false)
    public void changeName_closeByClickBehind_windowCloses() {
        String surname = "Иванов";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();
        settingsPage.closeSettingsWindowByClickBehind(UserSettingsConstants.Selectors.WINDOW_CROSS, 150, 150);

        xPathElementShouldNotExist(UserSettingsConstants.Selectors.SETTINGS_WINDOW);
        xPathElementShouldExist(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_PAGE);
    }

    @Test
    public void changeName_emptyValue_errorDisplayed() {
        String name = "";

        settingsPage.setUserName(name);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextByXpath(String.format(UserSettingsConstants.Selectors.ERROR_MSG_EMPTY_NAME, UserSettingsConstants.Messages.EMPTY_NAME)), UserSettingsConstants.Messages.EMPTY_NAME);
    }

    @Test
    public void changeSurname_emptyValue_errorDisplayed() {
        String surname = "";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextByXpath(String.format(UserSettingsConstants.Selectors.ERROR_MSG_EMPTY_SURNAME, UserSettingsConstants.Messages.EMPTY_SURNAME)), UserSettingsConstants.Messages.EMPTY_SURNAME);
    }


    @Test
    public void changeName_useSpecialSymbols_errorDisplayed() {
        String name = "$";

        settingsPage.setUserSurname(name);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextByXpath(String.format(UserSettingsConstants.Selectors.ERROR_MSG_USE_ONLY_LETTERS, UserSettingsConstants.Messages.USE_ONLY_LETTERS)), UserSettingsConstants.Messages.USE_ONLY_LETTERS);
    }

    @Test
    public void changeSurname_useSpecialSymbols_errorDisplayed() {
        String surname = "$";

        settingsPage.setUserSurname(surname);
        settingsPage.saveChanges();

        Assert.assertEquals(getTextByXpath(String.format(UserSettingsConstants.Selectors.ERROR_MSG_USE_ONLY_LETTERS, UserSettingsConstants.Messages.USE_ONLY_LETTERS)), UserSettingsConstants.Messages.USE_ONLY_LETTERS);
    }

    @Test
    public void changeDOB_changeAllDates_dobDisplaysCorrectly() {
        String new_day = "23";
        String new_month = "июнь";
        String new_year = "2000";

        try {
            settingsPage.setDayOfBirth(new_day);
            settingsPage.setMonthOfBirth(new_month);
            settingsPage.setYearOfBirth(new_year);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_DOB_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }

    }

    @Test
    public void changeDOB_changeDayToInvalid_dobDisplaysCorrectly() {
        String new_day = "день";

        settingsPage.setDayOfBirth(new_day);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeMonthToInvalid_dobDisplaysCorrectly() {
        String new_month = "месяц";

        settingsPage.setMonthOfBirth(new_month);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeYearToInvalid_dobDisplaysCorrectly() {
        String new_year = "год";

        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeYearTo1911_errorDisplays() {
        String new_year = "1911";

        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.LONG_LIVE_RECORD, UserSettingsConstants.Messages.LONGEST_LIVING_RECORD_IS_BEATEN));
    }

    @Test
    public void changeDOB_changeDateTo29February_errorDisplays() {
        String new_day = "29";
        String new_month= "февраль";
        String new_year = "1989";

        settingsPage.setDayOfBirth(new_day);
        settingsPage.setMonthOfBirth(new_month);
        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeDateTo29FebruaryAndYearIsLeap_errorIsNotDisplayed() {
        String new_day = "29";
        String new_month= "февраль";

        try {
            settingsPage.setDayOfBirth(new_day);
            settingsPage.setMonthOfBirth(new_month);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.LEAP_YEAR_NEW_DATE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test
    public void changeDOB_changeDateTo29FebruaryAndYearIsNotLeap_errorDisplays() {
        String new_day = "29";
        String new_year = "1989";

        settingsPage.setDayOfBirth(new_day);
        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeDateTo30February_errorDisplays() {
        String new_day = "30";
        String new_month= "февраль";
        String new_year = "1989";

        settingsPage.setDayOfBirth(new_day);
        settingsPage.setMonthOfBirth(new_month);
        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeDOB_changeDateTo31February_errorDisplays() {
        String new_day = "31";
        String new_month= "февраль";
        String new_year = "1989";

        settingsPage.setDayOfBirth(new_day);
        settingsPage.setMonthOfBirth(new_month);
        settingsPage.setYearOfBirth(new_year);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.DOB_INCORRECT, UserSettingsConstants.Messages.DOB_IS_INCORRECT));
    }

    @Test
    public void changeGender_changeToWomen_changedSuccessfully() {

        try {
            settingsPage.changeGenderToWomen();
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_GENDER_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test
    public void setLivingPlace_emptyPlace_errorIsDisplayed() {
        String placeName = "";

        settingsPage.changeLivingCity(placeName);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.RESIDENCE_CITY_EMPTY, UserSettingsConstants.Messages.EMPTY_RESIDENCE_PLACE));
    }

    @Test
    public void setLivingPlace_specialChar_errorIsDisplayed() {
        String placeName = "$";

        settingsPage.changeOriginCity(placeName);
        settingsPage.saveChanges();

        xPathElementShouldExist(String.format(UserSettingsConstants.Selectors.RESIDENCE_CITY_EMPTY, UserSettingsConstants.Messages.INCORRECT_ORIGIN_CITY));
    }

    @Test
    public void setLivingPlace_newValidPlaceInRussian_successfullyChanged() {
        String newLivingCity = "Ярославль";

        try {
            settingsPage.changeLivingCity(newLivingCity);
            settingsPage.chooseCity(newLivingCity);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_RESIDENCE_CITY_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test
    public void setLivingPlace_10SearchResultsInReturn_success() {
        String LivingCity = "а";
        Integer resultsInReturn = 10;

        settingsPage.changeLivingCity(LivingCity);
        settingsPage.countElementsByXpathOnPage(UserSettingsConstants.Selectors.SUGGESTS_IN_RESULT, resultsInReturn);
    }

    @Test
    public void setLivingPlace_newValidPlaceInEnglish_successfullyChanged() {
        String newLivingCityInEnglish = "Yaro";
        String newLivingCityInRussian = "Ярославль";

        try {
            settingsPage.changeLivingCity(newLivingCityInEnglish);
            settingsPage.chooseCity(newLivingCityInRussian);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_RESIDENCE_CITY_CHANGE, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test
    public void settingsWindow_closeWindowUsingCross_windowsCloses() {
        settingsPage.closeSettingsWindowsByCross();

        xPathElementShouldNotExist(UserSettingsConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test
    public void settingsWindows_closeByClickBehind_windowCloses() {
        settingsPage.closeSettingsWindowByClickBehind(UserSettingsConstants.Selectors.WINDOW_CROSS, 150, 150);

        xPathElementShouldNotExist(UserSettingsConstants.Selectors.SETTINGS_WINDOW);
    }

    @Test
    public void setOriginCity_validChange_success() {
        String newOriginCity = "Ярославль";

        try {
            settingsPage.changeOriginCity(newOriginCity);
            settingsPage.chooseCity(newOriginCity);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_CHANGE_ORIGIN_CITY, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }

    }

    @Test
    public void setOriginCity_newPlaceInEnglish_success() {
        String newOriginCityInRussian = "Ярославль";
        String newOriginCityInEnglish = "Yaro";

        try {
            settingsPage.changeOriginCity(newOriginCityInEnglish);
            settingsPage.chooseCity(newOriginCityInRussian);
            settingsPage.saveChanges();

            waitForXpathElementContainText(UserSettingsConstants.Selectors.PERSONAL_INFORMATION_SUMMARY, UserSettingsConstants.Summary.AFTER_CHANGE_ORIGIN_CITY, 3000);
        }

        finally {
            settingsPage.setDefaultUserSettings();
        }
    }

    @Test
    public void setOriginPlace_10SearchResultsInReturn_success() {
        String originCity = "а";
        Integer resultsInReturn = 10;

        settingsPage.changeOriginCity(originCity);
        settingsPage.countElementsByXpathOnPage(UserSettingsConstants.Selectors.SUGGESTS_IN_RESULT, resultsInReturn);
    }

    @Test
    public void changesWereSavedMessage_isVisible() {
        settingsPage.saveChanges();
        isNoticeTextEqual(UserSettingsConstants.Messages.CHANGES_HAVE_BEEN_SAVED);
    }

}
