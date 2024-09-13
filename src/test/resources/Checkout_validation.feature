Feature: Validation of required fields during checkout

  Background: User is logged into Sauce Demo and navigates to the checkout information page
    Given I am in sauce demo web page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And The home page should be displayed
    And I add to the cart the product "Sauce Labs Backpack"
    And I click on the cart button
    And I click on the checkout button

  Scenario: Verify error message when postal code is not entered
    When I fill the first name with "John" and the last name with "Doe" leaving the zip code empty
    And I click on continue button
    Then A required field error message "Error: Postal Code is required" should be displayed
