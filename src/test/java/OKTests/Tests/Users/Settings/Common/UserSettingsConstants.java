package OKTests.Tests.Users.Settings.Common;

public class UserSettingsConstants {

    public static final class Selectors {
        public static final String PERSONAL_INFORMATION_PAGE = "//*[@class='user-settings_i_tx textWrap']";
        public static final String USER_NAME = "field_name";
        public static final String USER_SURNAME = "field_surname";
        public static final String SAVE_CHANGES_BUTTON = "hook_FormButton_button_savePopLayerEditUserProfileNew";
        public static final String NOTIFY_PANEL_MSG = "notifyPanel_msg";
        public static final String ERROR_MSG_EMPTY_NAME = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String ERROR_MSG_EMPTY_SURNAME = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String ERROR_MSG_USE_ONLY_LETTERS = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String DAY_OF_BIRTH = "field_bday";
        public static final String DAY_OF_BIRTH_DROPDOWN = "//*[@id = 'field_bday']//option[text() = '%s']";
        public static final String MONTH_OF_BIRTH = "field_bmonth";
        public static final String MONTH_OF_BIRTH_DROPDOWN = "//*[@id = 'field_bmonth']//option[text() = '%s']";
        public static final String YEAR_OF_BIRTH = "field_byear";
        public static final String YEAR_OF_BIRTH_DROPDOWN = "//*[@id = 'field_byear']//option[text() = '%s']";
        public static final String PERSONAL_INFORMATION_SUMMARY = "//*[@class='user-settings_i_tx textWrap']";
        public static final String PERSONAL_DATA_PAGE = "//*[contains(@class,'user-settings_i_n') and contains(text(),'%s')]";
        public static final String DOB_INCORRECT = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String LONG_LIVE_RECORD = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String RESIDENCE_CITY = "field_citySugg_SearchInput";
        public static final String ORIGIN_CITY = "field_cityBSugg_SearchInput";
        public static final String RESIDENCE_CITY_EMPTY = "//*[contains(@class,'input-e') and text() = '%s']";
        public static final String MALE_GENDER = "field_gender_1";
        public static final String FEMALE_GENDER = "field_gender_2";
        public static final String WINDOW_CROSS = "//*[@class='ic modal-new_close_ico']";
        public static final String SETTINGS_WINDOW = "//*[@class='modal-new_center']";
        public static final String SUGGESTS_IN_RESULT = "//*[@class='suggest_li']";
        public static final String CHOOSE_CITY = "//*[contains(@class,'ellip') and text() = '%s']";
    }

    public static final class Messages {
        public static final String CHANGING_NAME_ERROR = "??????, ?????????? ???????????? ?????? ?? ???? ????????????. ????????????????????, ????????????????????, ?????????? ??????????.";
        public static final String EMPTY_NAME = "????????????????????, ?????????????? ???????? ??????.";
        public static final String EMPTY_SURNAME = "????????????????????, ?????????????? ???????? ??????????????.";
        public static final String USE_ONLY_LETTERS = "????????????????????, ?????????????????????? ???????????? ??????????.";
        public static final String CHANGES_HAVE_BEEN_SAVED = "???????? ?????????????????? ??????????????????";
        public static final String EMPTY_RESIDENCE_PLACE = "????????????????????, ???????????????? ?????????? ???????????????????? ???? ????????????";
        public static final String INCORRECT_ORIGIN_CITY = "????????????????????, ???????????????? ???????????? ?????????? ???? ????????????.";
        public static final String LONGEST_LIVING_RECORD_IS_BEATEN = "???? ???????????? ???????????? ????????????????????!";
        public static final String DOB_IS_INCORRECT = "???????? ???????????? ???????????????? ???????????? ??????????????????????.";
        public static final String PERSONAL_DATA = "???????????? ????????????";
    }

    public static final class Summary {
        public static final String ORIGIN_TEXT = "?????????? ????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_DOB_CHANGE = "?????????? ????????????, ?????????????? 23 ???????? 2000, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_GENDER_CHANGE = "?????????? ????????????, ???????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_RESIDENCE_CITY_CHANGE = "?????????? ????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??????????????????";
        public static final String LEAP_YEAR_NEW_DATE = "?????????? ????????????, ?????????????? 29 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_NAME_CHANGE = "?????????????? ????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_SURNAME_CHANGE = "?????????? ????????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_NAME_MAX_LENGTH_CHANGE = "???????????????????????????????? ????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_SURNAME_MAX_LENGTH_CHANGE = "?????????? ????????????????????????????????????????????????, ?????????????? 10 ?????????????? 1988, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
        public static final String AFTER_CHANGE_ORIGIN_CITY = "?????????? ????????????, ?????????????? 10 ?????????????? 1988 ?? ???????????? ??????????????????, ???????????? ???????? ?? ???????????? ??. ???????????????? (?????????????????????? ??????????)";
    }

}
