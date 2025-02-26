package stepdefinitions;

import Common.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javax.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoblazeSignUpAndLogInPage;
import utils.Hooks;

import java.io.IOException;

/**
 * Covers a basic signin flow with an existing user and verifies signin success.
 */
public class DemobalzeSignInSteps {
    private final WebDriver driver;
    private final DemoblazeSignUpAndLogInPage demoblazeSignUpAndLogInPage;
    private final User testUser;

    @Inject
    public DemobalzeSignInSteps(Hooks hooks) throws IOException {
        this.driver = hooks.getDriver();
        this.demoblazeSignUpAndLogInPage = new DemoblazeSignUpAndLogInPage(driver);
        this.testUser = new User(
                "test_user_123456789",
                "test_user_123456789"
        );
    }

    @Given("the user is on the Demoblaze signin page")
    public void the_user_is_on_the_demoblaze_signin_page() {
        demoblazeSignUpAndLogInPage.openDemoblazePage();
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        demoblazeSignUpAndLogInPage.login(testUser);
    }

    @Then("the user should be successfully signed in")
    public void the_user_should_be_signed_in() {
        Assert.assertEquals(demoblazeSignUpAndLogInPage.getSignedInUserName().trim(), testUser.getName(), "Existing user login failed!");
    }
}//Class
