package Locators;

import org.openqa.selenium.By;

public class DemoblazeMainNavigationLocators {
    public static final By HOME = By.cssSelector("#navbarExample > ul > li.nav-item.active > a");
    public static final By CONTACT = By.cssSelector("#navbarExample > ul > li:nth-child(2) > a");
    public static final By ABOUT_US = By.cssSelector("#navbarExample > ul > li:nth-child(3) > a");
    public static final By CART = By.id("cartur");
    public static final By LOGIN = By.id("login2");
    public static final By LOGOUT = By.id("logout2");
    //public static final By USER_NAME = By.id("nameofuser");
    public static final By USER_NAME = By.xpath("//a[contains(text(), 'Welcome ')]");

    public static final By SIGNUP = By.id("signin2");
    public static final By CATEGORY_LIST = By.cssSelector(".list-group > a");

    public static final By LOG_IN_USER_NAME = By.id("loginusername");
    public static final By LOG_IN_PASSWORD = By.id("loginpassword");
    public static final By LOG_IN_BUTTON = By.cssSelector("button[onclick='logIn()']");
    public static final By LOGIN_CLOSE_BUTTON = By.cssSelector("div[id='logInModal'] div[class='modal-footer'] button:nth-child(1)");

    public static final By CATEGORIES_TITLE = By.id("cat");
    public static final By PHONES_LINK = By.cssSelector("div.list-group a.list-group-item[onclick=\"byCat('phone')\"]");
    public static final By LAPTOPS_LINK = By.cssSelector("div.list-group a.list-group-item[onclick=\"byCat('notebook')\"]");
    public static final By MONITOR_LINK = By.cssSelector("div.list-group a.list-group-item[onclick=\"byCat('monitor')\"]");

}//Class