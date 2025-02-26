package Locators;

import org.openqa.selenium.By;

public class DemoblazeSignUpAndLogInLocators {
    public static final By USERNAME = By.id("sign-username");
    public static final By PASSWORD = By.id("sign-password");
    public static final By SIGNUP_BUTTON = By.cssSelector("button[onclick='register()']");
    public static final By SIGNUP_CLOSE_BUTTON = By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary");

}//Class
