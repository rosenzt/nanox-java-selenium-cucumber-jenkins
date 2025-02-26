package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoblazeMainComponentsPage;
import utils.Hooks;

/**
 * Cover the presence of main components on the Dempblaze homepage.
 */
public class DemoblazeUiSteps {
    private final WebDriver driver;
    private final DemoblazeMainComponentsPage demoblazeMainComponentsPage;

    public DemoblazeUiSteps(Hooks hooks) throws Exception {  // ✅ Pass Hooks instance
        this.driver = hooks.getDriver();
        this.demoblazeMainComponentsPage = new DemoblazeMainComponentsPage(driver);
    }

    @Given("the user is on the Demoblaze homepage and verifies all main components")
    public void the_user_is_on_the_demoblaze_homepage_and_verifies_all_main_components() {
        demoblazeMainComponentsPage.openDemoblazePage();
        Assert.assertTrue(demoblazeMainComponentsPage.verifyMainComponents(), "Main components verification failed!");
    }
}