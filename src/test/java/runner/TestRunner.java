package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/**
 * TestRunner - Executes Cucumber tests using TestNG.
 * Loads feature files and binds step definitions.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "utils"},  // ✅ Ensures Hooks is used properly
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}