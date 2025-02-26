package Locators;

import org.openqa.selenium.By;

public class DemoblazePurchaseLocators {

    public static final By GALAXY_S6 = By.cssSelector("a[href='prod.html?idp_=1']");
    public static final By GALAXY_S7 = By.cssSelector("a[href='prod.html?idp_=4']");
    public static final By PRODUCT_PAGE_NAME = By.cssSelector(".name");
    public static final By PRODUCTS_NAMES_IN_CART = By.cssSelector("table tbody tr td:nth-child(2)");
    public static final By PRODUCT_PRICE_ON_PRODUCT_PAGE = By.cssSelector(".price-container");
    public static final By ADD_TO_CART = By.cssSelector("#tbodyid > div.row > div > a");
    public static final By DEMOBLAZE_LOGO = By.cssSelector("#nava");
    public static final By CART = By.cssSelector("a[href='cart.html']");
    public static final By TOTAL_AMOUNT = By.cssSelector("#totalp");
    public static final By PLACE_ORDER_BUTTON = By.cssSelector(".btn.btn-success");
    public static final By ORDER_FORM_NAME = By.cssSelector("#name");
    public static final By ORDER_FORM_COUNTRY = By.cssSelector("#country");
    public static final By ORDER_FORM_CITY = By.cssSelector("#city");
    public static final By ORDER_FORM_CREDIT_CARD = By.cssSelector("#card");
    public static final By ORDER_FORM_MONTH = By.cssSelector("#month");
    public static final By ORDER_FORM_YEAR = By.cssSelector("#year");
    public static final By ORDER_FORM_PURCHASE_BUTTON = By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary");
    public static final By ORDER_FORM_CLOSE_BUTTON = By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-secondary");
    public static final By ORDER_CONFIRMATION_MODAL_TEXT= By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > p.lead.text-muted");


}//Class