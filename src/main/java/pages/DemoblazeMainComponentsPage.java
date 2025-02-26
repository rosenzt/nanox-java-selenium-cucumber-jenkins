package pages;

import Locators.DemoblazeMainNavigationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
* DemoblazeMainComponentsPage - handles the verification of main components on the Demoblaze home page.
 */
public class DemoblazeMainComponentsPage extends BasePage {


    public DemoblazeMainComponentsPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /***
     * Verifies the top navigation bar is present
     * @return true if all components are present, false if at least one is not.
     */
    public boolean verifyNavBarComponents() {
        boolean passed = true;
        List<By> navBarElements = Arrays.asList(
                DemoblazeMainNavigationLocators.HOME,
                DemoblazeMainNavigationLocators.CONTACT,
                DemoblazeMainNavigationLocators.ABOUT_US,
                DemoblazeMainNavigationLocators.CART,
                DemoblazeMainNavigationLocators.LOGIN,
                DemoblazeMainNavigationLocators.SIGNUP);

        for (By element : navBarElements) {
            if (!isElementPresent(element)) {
                passed = false;
            }
        }
        return passed;
    }

    /**
     * Verifies the presence of the categories filters
     * @return true if all filters buttons are present, false if at least one is not
     */
    public boolean verifyCategoriesListIsPresent() {
        boolean passed = true;
        List<By> categoriesList = Arrays.asList(
                DemoblazeMainNavigationLocators.CATEGORIES_TITLE,
                DemoblazeMainNavigationLocators.PHONES_LINK,
                DemoblazeMainNavigationLocators.LAPTOPS_LINK,
                DemoblazeMainNavigationLocators.MONITOR_LINK
        );

        for (By element : categoriesList) {
            if (!isElementPresent(element)) {
                passed = false;
            }
        }
        return passed;
    }

    /**
     * Runs both methods above
     * @return true if both methods return true, false if at least one returned false.
     */
    public boolean verifyMainComponents() {
        boolean passed = true;
        if (!verifyNavBarComponents()) {
            passed = false;
        }
        if (!verifyCategoriesListIsPresent()) {
            passed = false;
        }
       return passed;
    }
}//Class
