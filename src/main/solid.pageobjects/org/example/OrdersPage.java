package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import solid.AbstractComponents.AbstractComponent;

import java.util.List;

public class OrdersPage extends AbstractComponent {

    WebDriver driver;
    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> orderProducts;

    public Boolean VerifyOrdersDisplay(String productName){
        Boolean match = orderProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }
}
