Feature: Add multiple products to the cart and verify they are present

  Background: User is logged into Sauce Demo and navigates to the product page
    Given I am in sauce demo web page
    And I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And The home page should be displayed


  Scenario Outline: Add products, verify they are in the cart, and then remove them
    When I add the following products to the cart
      | <product1>   |
      | <product2>   |
    And I click on the cart button
    Then The following products should be in the cart
      | <product1>   |
      | <product2>   |
    When I remove the following products from the cart
      | <product1>   |
      | <product2>   |
    Then The cart should be empty

    Examples:
      | product1           | product2           |
      | Sauce Labs Backpack| Sauce Labs Bike Light|
      | Sauce Labs Onesie  | Sauce Labs Bolt T-Shirt|


  Scenario: Add multiple products and verify they are in the cart
    When I add the following products to the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And I click on the cart button
    Then The following products should be in the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

