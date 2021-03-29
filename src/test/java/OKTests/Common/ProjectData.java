package OKTests.Common;

public final class ProjectData {

    public static final class Selectors {
        public static final String LOGIN_INPUT = "[name='st.email']";
        public static final String PASSWORD_INPUT = "[name='st.password']";
        public static final String SUBMIT_BUTTON = "//*[@class='button-pro __wide']";
        public static final String CLOSE_BUTTON = "buttonId_button_close";
        public static final String NOTICE = "//*[contains(@class,'tip __active')]//*[text()='%s']";
    }

    public static final class UserData {
        public static final String USER_NAME = "Игорь";
        public static final String USER_SURNAME = "Машков";
        public static final String DAY_OF_BIRTH = "10";
        public static final String MONTH_OF_BIRTH = "февраль";
        public static final String YEAR_OF_BIRTH = "1988";
        public static final String OLD_CITY_NAME = "г. Голицыно (Одинцовский район)";
    }

}
