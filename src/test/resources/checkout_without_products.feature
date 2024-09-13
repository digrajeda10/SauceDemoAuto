Feature: Bug in checkout process without products

  Background: User is logged into Sauce Demo and navigates to the cart page
    Given I am in sauce demo web page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And The home page should be displayed
    And I click on the cart button

  Scenario: Verify that user is allowed to proceed to checkout with an empty cart
    When I try to proceed to checkout without any products
    Then I should not be able to proceed to checkout and it should be reported as a bug
