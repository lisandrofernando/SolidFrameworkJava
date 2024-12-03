package org.test.example;

import org.example.*;
import org.openqa.selenium.WebElement;
import org.test.components.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test extends BaseTest {
   String productName = "ZARA COAT 3";
//    String countryName = "india";
    @org.testng.annotations.Test(dataProvider="getData")
    public void submitOrderTest(HashMap<String, String> input) throws IOException {

        ProductCatalogue catalogue = page.loginMethod(input.get("email"),input.get("password"));
        List<WebElement> products = catalogue.getProductList();
        catalogue.addProductToCart(input.get("product"));
        CartPage cart = catalogue.goToCatPage();
        Boolean match = cart.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkout =  cart.goToCheckout();
        checkout.selectCountry(input.get("country"));
        ConfirmationPage confirmation = checkout.submitOrder();
        String confirmMessage = confirmation.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @org.testng.annotations.Test(dependsOnMethods = {"submitOrderTest"})
    public void orderHistoryTest(){
        ProductCatalogue catalogue = page.loginMethod("lisandrofernando@demo.com","Lisandro100@" );
        OrdersPage ordersPage = catalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrdersDisplay(productName));
    }
    @DataProvider
    public Object [][] getData(){
        HashMap<String, String> map = new HashMap<>();
        map.put("email","lisandrofernando@demo.com");
        map.put("password","Lisandro100@");
        map.put("product","ZARA COAT 3");
        map.put("country","india");
        return new Object [] [] {{map}};
    }
}
