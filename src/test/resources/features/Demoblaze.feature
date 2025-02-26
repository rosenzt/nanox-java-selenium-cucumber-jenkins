Feature: Demoblaze Automation Tests

@Purchase
Scenario: User adds a product to the cart
  Given the user opened Demoblaze homepage
  When the user adds a product to the cart
  Then the product should be successfully added to the cart
  When the user proceeds to checkout
  Then the purchase should be successful

@MainComponents
Scenario: Verify main components on Demoblaze homepage
    Given the user is on the Demoblaze homepage and verifies all main components

@SignIn
Scenario: User successfully logs into Demoblaze
  Given the user is on the Demoblaze signin page
  When the user enters valid username and password
  Then the user should be successfully signed in

@SignInWithRandomUser
Scenario: A random user will not be able to sign in
  Given the user has browsed to Demoblaze homepage
  When the user enters invalid credentials
  Then the signin will not be successful

@Signup
Scenario: User successfully signs up and logs into Demoblaze
  Given the user is on the Demoblaze signup page
  When the user enters valid signup details
  Then the user account should be created successfully
  When the user logs in with the new user
  Then the user should be successfully logged in