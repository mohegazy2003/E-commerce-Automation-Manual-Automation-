package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;


public class BaseClass {

    public WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://automationexercise.com/");

    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}



