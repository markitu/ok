package OKTests.Tests.Users.Settings.Common;

import OKTests.Common.PropertiesLoader;
import OKTests.Common.TestBase;
import OKTests.Common.WebDriverConfig;
import OKTests.Tests.Users.Settings.Pages.SettingsPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class PersonalInformationBase extends TestBase {

    protected final WebDriverConfig wd = new WebDriverConfig();

    public SettingsPage settingsPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        wd.init();

        settingsPage = new SettingsPage();

        open(PropertiesLoader.getProp("URL"));
        loginAsUser(PropertiesLoader.getProp("USER_LOGIN"), PropertiesLoader.getProp("USER_PASSWORD"));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        wd.stop();
    }

    @BeforeMethod
    public void init() {
        openSettingsPage();
        settingsPage.editPersonalInformation();
    }

}
