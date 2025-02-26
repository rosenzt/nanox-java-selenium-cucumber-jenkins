package pages;

import Common.User;
import Locators.DemoblazePurchaseLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DemoblazePurchasePage - Handles the purchasing process on Demoblaze.
 * Includes adding products to the cart, verifying cart contents, and completing purchases.
 */
public class DemoblazePurchasePage extends BasePage {

    private final List<String> productsRequested = new ArrayList<String>();
    private final List<String> productsFoundInCart = new ArrayList<String>();
    int expectedTotalCost;
    int foundProductCost;

    public DemoblazePurchasePage(WebDriver driver) throws IOException {
        super(driver);
    }

    /**
     * Adds a specified product to the shopping cart.
     * @param locator By - The By locator of the product to be added
     */
    public void addToCart(By locator) {
        click(waitTillVisible(locator));
        waitTillVisible(DemoblazePurchaseLocators.PRODUCT_PAGE_NAME);
        productsRequested.add(getText(DemoblazePurchaseLocators.PRODUCT_PAGE_NAME));

        int productPrice = Integer.parseInt(getText(DemoblazePurchaseLocators.PRODUCT_PRICE_ON_PRODUCT_PAGE)
                .substring(1, getText(DemoblazePurchaseLocators.PRODUCT_PRICE_ON_PRODUCT_PAGE).indexOf(" ")));

        expectedTotalCost += productPrice;

        click(DemoblazePurchaseLocators.ADD_TO_CART);
        isAlertPresent();
    }

    /**
     * Opens the cart page and verifies if the total amount in the cart matches the expected value.
     * @return if the total cost is correct, false otherwise.
     */
    public boolean openCartAndVerifyAmount() {
        click(waitTillVisible(DemoblazePurchaseLocators.CART));

        foundProductCost = Integer.parseInt(getText(waitTillVisible(DemoblazePurchaseLocators.TOTAL_AMOUNT)));

        return foundProductCost == expectedTotalCost;
    }

    /**
     * Populates the productsFoundInCart variable for the
     */
    private void getProductsInCart() {
        List<WebElement> productNames = driver.findElements(DemoblazePurchaseLocators.PRODUCTS_NAMES_IN_CART);
        for (WebElement product : productNames) {
            productsFoundInCart.add(product.getText());
        }
    }

    /***
     * Comparing the two lists: the list of products requested and the one of products found
     * @return true in case the lists match, false in case they do not.
     */
    public boolean compareProducts() {
        getProductsInCart();
        if (!productsFoundInCart.isEmpty() && !productsRequested.isEmpty()) {
            return productsRequested.equals(productsFoundInCart);
        } else {
            return false;
        }
    }

    /**
     * Completes an order by entering user details and submitting the form.
     * @param user The User object containing customer details for purchase.
     */
    public void placeOrder(User user) {
        click(DemoblazePurchaseLocators.PLACE_ORDER_BUTTON);

        populateField(DemoblazePurchaseLocators.ORDER_FORM_NAME, user.getName());
        populateField(DemoblazePurchaseLocators.ORDER_FORM_COUNTRY, user.getCountry());
        populateField(DemoblazePurchaseLocators.ORDER_FORM_CITY, user.getCity());
        populateField(DemoblazePurchaseLocators.ORDER_FORM_CREDIT_CARD, user.getCreditCardNumber());
        populateField(DemoblazePurchaseLocators.ORDER_FORM_MONTH, user.getMonth());
        populateField(DemoblazePurchaseLocators.ORDER_FORM_YEAR, user.getYear());

        click(DemoblazePurchaseLocators.ORDER_FORM_PURCHASE_BUTTON);
    }

    /**
     * Verifies an order placed for the Users name, the credit card number and the amount
     * @param user - the user object for the user to be compared
     * @return true is the parameters match, false in case at least one does not
     */
    public boolean verifyOrder(User user) {
        WebElement alertElement = driver.findElement(DemoblazePurchaseLocators.ORDER_CONFIRMATION_MODAL_TEXT);

        String alertText = alertElement.getText();

        Map<String, String> details = new HashMap<>();

        for (String line : alertText.split("\n")) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                details.put(parts[0].trim(), parts[1].trim());
            }
        }
        boolean passed = true;
        if (!user.getName().equals(details.get("Name"))){
            passed = false;
        }

        if (!user.getCreditCardNumber().equals(details.get("Card Number"))){
            passed = false;
        }

        if (expectedTotalCost != Integer.parseInt(details.get("Amount").substring(0,details.get("Amount").indexOf(" ")))){
            passed = false;
        }
        return passed;
    }
}//Class