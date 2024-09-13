Feature: Product sorting by price

  Background: User is logged into Sauce Demo and navigates to the product page
    Given I am in sauce demo web page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And The home page should be displayed

  Scenario: Verify products are sorted by price from low to high
    When I select the product sort order "Price (low to high)"
    Then The products should be sorted by price in ascending order
