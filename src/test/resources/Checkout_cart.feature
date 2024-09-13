Feature: Verify cart persistence after logout

  Background: User is logged into Sauce Demo and adds products to the cart
    Given I am in sauce demo web page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And I add to the cart the product "Sauce Labs Backpack"
    And I add to the cart the product "Sauce Labs Bike Light"
    And I click on the cart button

  Scenario: Verify products remain in the cart after logout and login
    When I log out from the home page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And I click on the cart button
    Then The product "Sauce Labs Backpack" should still be in the cart
    And The product "Sauce Labs Bike Light" should still be in the cart
