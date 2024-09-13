package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }

    @When("I log out from the home page")
    public void i_log_out_from_the_home_page(){
        homePage.logout();
    }

    @When("I select the product sort order {string}")
    public void iSelectProductSortOrder(String order) {
        homePage.selectProductSortOrder(order);
    }

    @Then("The products should be sorted by price in ascending order")
    public void verifyProductsSortedByPriceAscending() {
        List<Double> prices = homePage.getProductPrices();

        List<Double> sortedPrices = prices.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedPrices, prices, "The products are not sorted by price in ascending order.");
    }
}
