package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.YourCartPage;

import java.util.List;

public class YourCartSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);
    YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

    @And("I click on the checkout button")
    public void clickOnCheckoutButton(){
        yourCartPage.clickOnCheckoutButton();
    }

    @Then("The product {string} should still be in the cart")
    public void the_product_should_still_be_in_the_cart(String productName){
        Assertions.assertTrue(yourCartPage.verifyProductInCart(productName), "The product is not in the cart");
    }

    @When("I try to proceed to checkout without any products")
    public void iTryToCheckoutWithoutProducts() {
        Assertions.assertTrue(yourCartPage.isCartEmpty(), "The cart is not empty, expected it to be empty.");
        yourCartPage.clickOnCheckoutButton();  // Intentamos hacer checkout incluso si el carrito está vacío
    }

    @Then("I should not be able to proceed to checkout and it should be reported as a bug")
    public void verifyBugAllowsCheckoutWithoutProducts() {
        // BUG
        Assertions.fail("Bug: The system allows checkout without products in the cart.");
    }

    @When("I add the following products to the cart")
    public void iAddProductsToCart(DataTable productsTable) {
        List<String> products = productsTable.asList(String.class);
        for (String product : products) {
            homePage.addProductToCart(product);
        }
    }

    @Then("The following products should be in the cart")
    public void verifyProductsInCart(DataTable productsTable) {
        List<String> expectedProducts = productsTable.asList(String.class);
        for (String product : expectedProducts) {
            Assertions.assertTrue(yourCartPage.verifyProductInCart(product),
                    "The product " + product + " is not in the cart");
        }
    }

    @When("I remove the following products from the cart")
    public void iRemoveProductsFromCart(DataTable productsTable) {
        List<String> products = productsTable.asList(String.class);
        for (String product : products) {
            homePage.removeProductFromCart(product);  // Método para eliminar productos
        }
    }

    @Then("The cart should be empty")
    public void verifyCartIsEmpty() {
        Assertions.assertTrue(yourCartPage.isCartEmpty(), "The cart is not empty.");
    }

}
