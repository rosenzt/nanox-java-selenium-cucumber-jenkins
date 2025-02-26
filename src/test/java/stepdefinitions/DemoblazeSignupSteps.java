package stepdefinitions;

import io.cucumber.java.en.*;
import javax.inject.Inject;  // ✅ Corrected import for DI
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoblazeSignUpAndLogInPage;
import utils.Hooks;
import Common.User;

/**
 * Covers a new user signup flow, and a signin with the new user.
 */
public class DemoblazeSignupSteps {
    private final WebDriver driver;
    private final DemoblazeSignUpAndLogInPage demoblazeSignUpAndLogInPage;
    private final User newUser;

    @Inject
    public DemoblazeSignupSteps(Hooks hooks) throws Exception {
        this.driver = hooks.getDriver();  // ✅ Uses the singleton WebDriver
        this.demoblazeSignUpAndLogInPage = new DemoblazeSignUpAndLogInPage(driver);
        this.newUser = new User("user_" + System.currentTimeMillis(), "password123");
    }

    @Given("the user is on the Demoblaze signup page")
    public void the_user_is_on_the_demoblaze_signup_page() {
        demoblazeSignUpAndLogInPage.openDemoblazePage();
    }

    @When("the user enters valid signup details")
    public void the_user_enters_valid_signup_details() {
        demoblazeSignUpAndLogInPage.signUp(newUser);
    }

    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        Assert.assertTrue(demoblazeSignUpAndLogInPage.isAlertPresent(), "Signup failed!");
    }

    @When("the user logs in with the new user")
    public void the_user_logs_in_with_the_new_user() {
        demoblazeSignUpAndLogInPage.login(newUser);
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        Assert.assertEquals(demoblazeSignUpAndLogInPage.getSignedInUserName().trim(), newUser.getName(), "New user login failed!");
    }
}
