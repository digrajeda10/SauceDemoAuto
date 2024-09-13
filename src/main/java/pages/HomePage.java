package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitle;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    //agregados

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        if(sauceDemoTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isProductInHomePage(String productName){
        for(WebElement element : productsTitle){
            if(element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        // add-to-cart-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public boolean verifyCartIconNumber(String cartNumber){
        String actualCartNumber = cartIcon.getText();
        if(actualCartNumber.equalsIgnoreCase(cartNumber)){
            return true;
        }
        return false;
    }

    public void removeProductFromCart(String productName){
        // remove-sauce-labs-bolt-t-shirt
        // sauce labs bolt t-shirt
        String productId = "remove-"+productName.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }

    public void clickOnCartButton(){
        cartIcon.click();
    }

    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        menuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public void selectProductSortOrder(String order) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(order);  // Ordenar por texto visible, como "Price (low to high)"
    }

    public List<Double> getProductPrices(){
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            // Limpiamos el texto del precio (ej: $29.99 -> 29.99)
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));  // Convertimos el texto a double
        }
        return prices;
    }

    public void resetAppState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        menuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(resetAppStateButton));
    }

}
