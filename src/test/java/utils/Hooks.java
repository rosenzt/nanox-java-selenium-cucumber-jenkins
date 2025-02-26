package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import javax.inject.Singleton;

/**
* Hooks - Manages WebDriver lifecycle for Cucumber tests.
* Ensures browser initialization before each test and cleanup after execution.
 */
@Singleton
public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {  // ✅ Prevents multiple browsers from opening
            System.out.println("[HOOKS] Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu", "--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("[HOOKS] WebDriver initialized.");
        }
    }

    /**
     *Closes WebDriver after each scenario.
     */
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Retrieves the current WebDriver instance.
     * @return WebDriver instance.
     * @throws IllegalStateException if the WebDiver is not initialized
     */
    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("[ERROR] WebDriver is not initialized! Check Hooks setup.");
        }
        return driver;
    }
}
