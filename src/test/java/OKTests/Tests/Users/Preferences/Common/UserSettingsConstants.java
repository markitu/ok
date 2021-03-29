package OKTests.Tests.Users.Preferences.Common;

public class UserSettingsConstants {

    public static final class Selectors {
        public static final String PERSONAL_INFORMATION_PAGE = "//*[@class='user-settings_i_tx textWrap']";
        public static final String USER_NAME = "field_name";
        public static final String USER_SURNAME = "field_surname";
        public static final String SAVE_CHANGES_BUTTON = "hook_FormButton_button_savePopLayerEditUserProfileNew";
        public static final String CANCEL_BUTTON = "hook_FormButton_button_cancelPopLayerEditUserProfileNew";
        public static final String NOTIFY_PANEL_MSG = "notifyPanel_msg";
        public static final String ERROR_FORM = "//*[contains(@class,'input-e') and contains(text(),'Пожалуйста')]";
        public static final String DAY_OF_BIRTH = "field_bday";
        public static final String MONTH_OF_BIRTH = "field_bmonth";
        public static final String YEAR_OF_BIRTH = "field_byear";
        public static final String SUMMARY_PERSONAL_INFORMATION = "//*[@class='user-settings_i_tx textWrap']";
        public static final String PERSONAL_DATA_PAGE = "//*[contains(@class,'user-settings_i_n') and contains(text(),'Личные данные')]";
        public static final String DOB_INCORRECT = "//*[contains(@class,'input-e') and text() = 'День вашего рождения указан некорректно.']";
        public static final String LONG_LIVE_RECORD = "//*[contains(@class,'input-e') and text() = 'Вы побили рекорд долголетия!']";
        public static final String LIVING_CITY = "field_citySugg_SearchInput";
        public static final String ORIGIN_CITY = "field_cityBSugg_SearchInput";
        public static final String LIVING_CITY_EMPTY = "//*[contains(@class,'input-e') and text() = 'Пожалуйста, выберите место проживания из списка']";
        public static final String MALE_GENDER = "field_gender_1";
        public static final String FEMALE_GENDER = "field_gender_2";
        public static final String WINDOW_CROSS = "//*[@class='ic modal-new_close_ico']";
        public static final String SETTINGS_WINDOW = "//*[@class='modal-new_center']";
        public static final String SUGGESTS_IN_RESULT = "//*[@class='suggest_li']";
    }


    public static final class Messages {
        public static final String CHANGING_NAME_ERROR = "Увы, часто менять имя в ОК нельзя. Попробуйте, пожалуйста, через сутки.";
        public static final String EMPTY_NAME = "Пожалуйста, укажите ваше имя.";
        public static final String EMPTY_SURNAME = "Пожалуйста, укажите вашу фамилию.";
        public static final String USE_ONLY_LETTERS = "Пожалуйста, используйте только буквы.";
        public static final String CHANGES_HAVE_BEEN_SAVED = "Ваши настройки сохранены";
    }

    public static final class Summary {
        public static final String ORIGIN_TEXT = "Игорь Машков, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_DOB_CHANGE = "Игорь Машков, родился 23 июня 2000, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_GENDER_CHANGE = "Игорь Машков, родилась 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String BEFORE_GENDER_CHANGE = "Игорь Машков, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_LIVING_CITY_CHANGE = "Игорь Машков, родился 10 февраля 1988, сейчас живу в городе Ярославль";
        public static final String BEFORE_LIVING_CITY_CHANGE = "Игорь Машков, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String LEAP_YEAR_NEW_DATE = "Игорь Машков, родился 29 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_NAME_CHANGE = "Дмитрий Машков, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_SURNAME_CHANGE = "Игорь Стольный, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_NAME_MAX_LENGTH_CHANGE = "аааааааааааааааа Машков, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_SURNAME_MAX_LENGTH_CHANGE = "Игорь аааааааааааааааааааааааа, родился 10 февраля 1988, сейчас живу в городе г. Голицыно (Одинцовский район)";
        public static final String AFTER_CHANGE_ORIGIN_CITY = "Игорь Машков, родился 10 февраля 1988 в городе Ярославль, сейчас живу в городе г. Голицыно (Одинцовский район)";
    }
}
