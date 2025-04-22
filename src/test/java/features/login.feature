Feature: Login functionality

  @Login
  Scenario: Successful login with valid credentials
    Given the app is launched
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks the login button
    Then the user should see the product title

  @ProductFlow
  Scenario: Successful login and purchase flow with valid credentials
    Given the app is launched
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks the login button
    Then the user should see the product title
    And the user should see the product list

    When the user selects a product
    And the user adds the product to the cart
    Then the user should see the cart icon with the correct number of items

    When the user clicks on the cart icon
    Then the user should be navigated to the cart screen

    When the user clicks on the checkout button
    Then the user should be navigated to the checkout screen

    When the user enters first name "John"
    And the user enters last name "Doe"
    And the user enters postal code "12345"
    And the user clicks the continue button
    Then the user should be navigated to the overview screen
    #And the user should see the product title
    #And the user should see the product list
    And the user should see the total price

    When the user clicks on the finish button
    Then the user should be navigated to the confirmation screen
    And the user should see the confirmation message

    When the user clicks on the back home button
    Then the user should be navigated to the home screen


    #faizanmf



