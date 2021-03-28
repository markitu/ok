package OKTests.Tests.Users.Preferences.Common;

import OKTests.Common.PropertiesLoader;
import OKTests.Common.TestBase;
import OKTests.Common.WebDriverConfig;
import OKTests.Tests.Users.Preferences.Pages.PreferencesPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class PersonalInformationBase extends TestBase {

    protected final WebDriverConfig wd = new WebDriverConfig();

    public PreferencesPage prefPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        wd.init();

        prefPage = new PreferencesPage();

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
        prefPage.editPersonalInformation();
    }

}
