package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;
     @BeforeTest
    public void setup(){
         driver = new FirefoxDriver();
         driver.manage().window().maximize();
         goHome();
     }
     @BeforeMethod
    public void goHome(){
         driver.get("https://automationexercise.com/");
     }
     @AfterClass
    public void closeBrowser(){
         driver.quit();
     }
}
