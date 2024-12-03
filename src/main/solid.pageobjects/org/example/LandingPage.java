package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import solid.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
        WebDriver driver;
        public LandingPage(WebDriver driver){
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        //WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        // PageFactory
        @FindBy(xpath="//input[@id='userEmail']")
        WebElement userEmail;

        @FindBy(css = "[type='password']")
        WebElement password;

        @FindBy(id= "login")
        WebElement loginButton;

        @FindBy(css = "[class*='flyInOut']")
        WebElement errorMessage;

        public ProductCatalogue loginMethod(String email, String pass){
            userEmail.sendKeys(email);
            password.sendKeys(pass);
            loginButton.click();
            ProductCatalogue catalogue =  new ProductCatalogue(driver);
            return catalogue;
        }

        public String getErrorMessage(){
            waitForWeElementToAppear(errorMessage);
           return errorMessage.getText();
        }

        public void goTo(){
            driver.get("https://rahulshettyacademy.com/client/");
        }
    }

