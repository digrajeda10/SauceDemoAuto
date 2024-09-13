package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class YourCartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartProducts;  // Productos en el carrito

    @FindBy(className = "cart_item")
    List<WebElement> cartItems;  // Elementos del carrito

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public boolean verifyProductInCart(String productName) {
        for (WebElement product : cartProducts) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

}
