package org.test.components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage page;
    public WebDriver initializeDriver() throws IOException {

        Properties prop =  new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalBrowsing.properties");
        prop.load(file);
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =  new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("MicrosoftEdge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
       driver = initializeDriver();
        page = new LandingPage(driver);
        page.goTo();
        return page;
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
