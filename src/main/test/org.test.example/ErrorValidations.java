package org.test.example;

import org.example.CartPage;
import org.example.CheckoutPage;
import org.example.ConfirmationPage;
import org.example.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.test.components.BaseTest;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest {
    @org.testng.annotations.Test
    public void loginErrorValidation() throws IOException {
        page.loginMethod("lisandroferando@demo.com","Lisandro100@" );
        Assert.assertEquals("Incorrect email or password.",page.getErrorMessage());
    }
    @org.testng.annotations.Test
    public void submitOrderTest() throws IOException {

        String productName = "ZARA COAT 3";
        ProductCatalogue catalogue = page.loginMethod("lisandrofernando@demo.com","Lisandro100@" );
        catalogue.getProductList();
        catalogue.addProductToCart(productName);
        CartPage cart = catalogue.goToCatPage();
        Boolean match = cart.VerifyProductDisplay("ZARA COAT 43");
        Assert.assertFalse(match);
    }

}
