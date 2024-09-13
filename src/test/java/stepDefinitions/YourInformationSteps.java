package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.YourInformationPage;

import java.util.List;

public class YourInformationSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation) throws InterruptedException {
        List<String> data = checkoutInformation.transpose().asList(String.class);
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on continue button")
    public void clickOnContinueButton() throws InterruptedException {
        yourInformationPage.clickOnContinueButton();
    }

    @When("I fill the first name with {string} and the last name with {string} leaving the zip code empty")
    public void iFillCheckoutInformationWithoutZipCode(String firstName, String lastName) {
        yourInformationPage.setFirstNameTextBox(firstName);
        yourInformationPage.setLastNameTextBox(lastName);
        yourInformationPage.setZipCodeTextBox("");  // No ingresamos el código postal
    }

    @Then("A required field error message {string} should be displayed")
    public void verifyRequiredFieldErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = yourInformationPage.getErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage, "The error message is not correct.");
    }
}
