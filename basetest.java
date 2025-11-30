package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class basetest {



    public WebDriver driver ;
    public HomePage homePage;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        goHome();
        homePage = new HomePage(driver);

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://automationexercise.com/");
    }
    @AfterClass
    public void closebrowser(){
        driver.quit();
    }
}

