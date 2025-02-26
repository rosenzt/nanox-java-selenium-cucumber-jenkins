WGH
#  Demoblaze Automation Testing

## Overview
A Selenium-based automation framework using **Cucumber** and **TestNG** for testing Demoblaze functionalities.

## ️ Tech Stack
- **Java 17+**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**

## Project Structure
```
|-- nanox-automation-project
    |
    |- src
    |   |
    |   |- main
    |   |   |
    |   |   |- java
    |   |      |
    |   |      |- Common
    |   |      |   |- User.java
    |   |      |
    |   |      |- Pages
    |   |      |   |- BasePage.java
    |   |      |   |- DemoblazeMainComponentsPage.java
    |   |      |   |- DemoblazePurchasePage.java
    |   |      |   |- DemoblazeSignUpAndLoginPage.java
    |   |      |
    |   |      |- Locators
    |   |          |- DemoblazeMainComponentsLocators.java
    |   |          |- DemoblazeMainNavigationLocators.java
    |   |          |- DemoblazeSignUpAndLoginLocators.java
    |   |
    |   |- test
    |       |
    |       |- java
    |       |   |
    |       |   |- stepDefinitions
    |       |   |   |- DemoblazeSignupSteps.java
    |       |   |   |- DemoblazePurchaseSteps.java
    |       |   |   |- DemoblazeSigninRandomUserSteps.java
    |       |   |   |- DemoblazeSignUpSteps.java
    |       |
    |       |   |- runner
    |       |   |   |- TestRunner.java
    |       |
    |       |   |- utils
    |       |        |- Hooks.java
    |       |
    |       |- resources
    |           |
    |           |- features
    |                |- Demoblaze.feature
    |
    |- pom.xml
```

## Setup & Installation
** 1. Clone the repository:**
```bash
git clone https://github.com/rosenzt/nanox-automation-project.git
cd nanox-automation-project
```
**2. Install dependencies:**
```bash
mvn clean install
```

## 🚀 Running Tests
### **Preferred Method: Run from IDE**
- **Right-click** on `TestRunner.java` → **Run 'TestRunner'**
- **OR** Click the **green play button** in IntelliJ/Eclipse

### **Run from Terminal**
Run all tests:
```bash
mvn test
```
Run specific tests:
```bash
mvn test -Dcucumber.filter.tags="@Signup"
```
Run multiple test groups:
```bash
mvn test -Dcucumber.filter.tags="@Signup or @MainComponents"
```

## Generating Reports
Generate an **HTML report** after running the tests:
```bash
mvn test -Dcucumber.plugin="pretty,html:target/cucumber-reports.html"
```
**View the report:** Open `target/cucumber-reports.html` in a browser.


