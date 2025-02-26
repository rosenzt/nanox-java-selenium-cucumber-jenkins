package stepdefinitions;

import Common.User;
import Locators.DemoblazeMainNavigationLocators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoblazeSignUpAndLogInPage;
import utils.Hooks;

import javax.inject.Inject;

/**
 * Covers a signin flow with a non-existing user and verifies signin fails.
 */
public class DemoblazeSignInRandomUserSteps {
    private final WebDriver driver;
    private final DemoblazeSignUpAndLogInPage demoblazeSignUpAndLogInPage;
    private final User randomUser;

    @Inject
    public DemoblazeSignInRandomUserSteps(Hooks hooks) throws Exception {
        this.driver = hooks.getDriver();
        this.demoblazeSignUpAndLogInPage = new DemoblazeSignUpAndLogInPage(driver);
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        this.randomUser = new User(
                "user_" + timeStamp,
                "password_" + timeStamp
        );
    }

    @Given("the user has browsed to Demoblaze homepage")
    public void the_User_Has_Browsed_To_Demoblaze_Homepage() {
        demoblazeSignUpAndLogInPage.openDemoblazePage();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        demoblazeSignUpAndLogInPage.signedUpWithNonExistingUser(randomUser);
    }

    @Then("the signin will not be successful")
    public void the_signin_will_not_be_successful() {
        Assert.assertTrue(demoblazeSignUpAndLogInPage.isElementPresent(DemoblazeMainNavigationLocators.LOGIN), "Random user has successfully logged in");
    }
}//Class
