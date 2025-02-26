package pages;

import Common.User;
import Locators.DemoblazeMainNavigationLocators;
import Locators.DemoblazeSignUpAndLogInLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

/**
 * DemoblazeSignUpAndLogInPage - handles the sign in and sign up processes on the Demoblaze web-page.
 */
public class DemoblazeSignUpAndLogInPage extends BasePage {

    public DemoblazeSignUpAndLogInPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /**
     * Performs a signup flow
      * @param user the user object containing customer details the signup.
     */
    public void signUp(User user) {
        click(DemoblazeMainNavigationLocators.SIGNUP);
        populateField(DemoblazeSignUpAndLogInLocators.USERNAME, user.getName());
        populateField(DemoblazeSignUpAndLogInLocators.PASSWORD, user.getPassword());
        click(DemoblazeSignUpAndLogInLocators.SIGNUP_BUTTON);
    }

    /**
     * Performs a signin flow
     * @param user The user object containing customer details for the signin.
     */
    public void login(User user) {
        click(DemoblazeMainNavigationLocators.LOGIN);
        populateField(DemoblazeMainNavigationLocators.LOG_IN_USER_NAME, user.getName());
        populateField(DemoblazeMainNavigationLocators.LOG_IN_PASSWORD, user.getPassword());
        click(DemoblazeMainNavigationLocators.LOG_IN_BUTTON);
    }

    /**
     * Obtains the username displayed on the top navigation bar.
     * @return the name displayed on the top navigation bar.
     */
    public String getSignedInUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userElement = wait.until(ExpectedConditions.visibilityOfElementLocated(DemoblazeMainNavigationLocators.USER_NAME));

        String welcomeText = getText(userElement);

        return welcomeText.substring(welcomeText.indexOf(" "));
    }

    /**
     * Performs a login with a user that is not to be successful as an alert will be presented
     * (in login flows it happens only when login fails)
     * @param user he user object containing customer details for the signin.
     */
    public void signedUpWithNonExistingUser(User user) {
        login(user);
        isAlertPresent();
        click(DemoblazeMainNavigationLocators.LOGIN_CLOSE_BUTTON);
    }
}//Class
