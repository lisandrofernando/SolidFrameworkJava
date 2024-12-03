package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import solid.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement checkoutElement;

    public Boolean VerifyProductDisplay(String productName){
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkoutElement.click();
        CheckoutPage checkout = new CheckoutPage(driver);
        return checkout;
    }
}
