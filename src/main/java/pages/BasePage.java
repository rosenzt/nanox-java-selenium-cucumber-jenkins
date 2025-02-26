package pages;

import Locators.DemoblazePurchaseLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * A parent page class for all page class, hold common use methods
 */
public class BasePage {

    protected WebDriver driver;
    Properties properties;
    private static final int DEFAULT_TIMEOUT = 10;

    public BasePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);
    }

    //Opens the Demoblaze homepage, waits until the logo is visible in oder to make sure the webpage is loaded
    public void openDemoblazePage() {
        driver.get(properties.getProperty("demoblazeHomePageUrl"));
        waitTillVisible(DemoblazePurchaseLocators.DEMOBLAZE_LOGO);
    }

    /**
     * Populating a text field
     * @param element - By the locator for the requested field
     * @param text - String to be placed
     */
    public void populateField(By element, String text) {
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
            sleep(200);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Exception thrown");
        }
    }

    /**
     * Clicking a web element
     * @param element - Web element to click on
     */
    public void click(WebElement element) {
        try {
            element.click();
            sleep(200);
        } catch (NoSuchElementException missingElement) {
            System.out.println("Exception thrown");
        }
    }

    /**
     * Clicking a web element accepting By
     * @param element - By locator to click on
     */
    public void click(By element) {
        try {
            driver.findElement(element).click();
            sleep(500);
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Exception thrown");
        }
    }

    /**
     * Retuning the text from a web element
     * @param element web element
     * @return The text found on the element
     */
    public String getText(WebElement element) {
        return element.getText();
    }
    /**
     * Retuning the text from a web element accepting By
     * @param element By
     * @return The text found on the element
     */
    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    /**
     * Verifying a web element accepting By
     * @param element
     * @return boolean
     */
    public boolean isElementPresent(By element) {
        boolean passed = false;
        try {
            passed = driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return passed;
    }

    /***
     * Verifying an alert popup is present and accepting it, by doing so closing it.
     * @return boolean
     */
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Waiting for web element (By) visibility, accepting the wait time requested
     * @param locator By
     * @param timeoutInSeconds
     * @return web element if the element is found, null in case it is not.
     */
    public WebElement waitTillVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // ✅ Returns the element
        } catch (Exception e) {
            System.out.println("[WARNING] Element " + locator + " not visible after " + timeoutInSeconds + " seconds.");
            return null; // ✅ Prevents crashes if element is not found
        }
    }

    /**
     * An over load for the above method, using the DEFAULT_TIMEOUT defined in the top of the class
     * @param locator
     * @return
     */
    public WebElement waitTillVisible(By locator) {
        return waitTillVisible(locator, DEFAULT_TIMEOUT);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            System.out.println("Exception thrown");
        }
    }
}//Class