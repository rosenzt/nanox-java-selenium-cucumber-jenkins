package stepdefinitions;

import Common.User;
import Locators.DemoblazePurchaseLocators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DemoblazePurchasePage;
import utils.Hooks;

import javax.inject.Inject;
/**
 * Step definitions for purchase scenarios in Demoblaze.
 * Covers adding items to the cart, produces in cart, cart amount, checkout, and purchase validation.
 */
public class DemoblazePurchaseSteps {
    private final WebDriver driver;
    private final DemoblazePurchasePage demoblazePurchasePage;
    private final User purchaseUser;

    @Inject
    public DemoblazePurchaseSteps(Hooks hooks) throws Exception{
        driver = hooks.getDriver();
        this.demoblazePurchasePage = new DemoblazePurchasePage(driver);
        this.purchaseUser = new User(
                "User",
                "userPassword",
                "userCountry",
                "userCity",
                "12345",
                "1",
                "1111"
        );
    }

    @Given("the user opened Demoblaze homepage")
    public void the_user_opened_Demoblaze_homepage() {
        demoblazePurchasePage.openDemoblazePage();
    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        demoblazePurchasePage.addToCart(DemoblazePurchaseLocators.GALAXY_S6);
    }

    @Then("the product should be successfully added to the cart")
    public void the_product_should_be_successfully_added_to_cart() {
        Assert.assertTrue(demoblazePurchasePage.openCartAndVerifyAmount(), "Cart amount is not as expected correctly.");
        Assert.assertTrue(demoblazePurchasePage.compareProducts(), "Product was not added correctly.");
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        demoblazePurchasePage.placeOrder(purchaseUser);
    }

   @Then("the purchase should be successful")
   public void the_purchase_should_be_successful() {
       Assert.assertTrue(demoblazePurchasePage.verifyOrder(purchaseUser), "Purchase verification failed!");
   }
}//Class