package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingUploginPage {
    WebDriver driver;
    public SingUploginPage(WebDriver driver) {
        this.driver = driver ;
    }
    //locator

    private By UserNameBox = By.name("name");
    private By SignupEmailaddressBox = By.xpath("(//input[@type='email'])[2]");
    private By signupButton = By.xpath("(//button[@type='submit'])[2]");
    private By errormessage = By.xpath("//p[@style='color: red;']");

    //Action

    public void insertUserName(String Username){
        driver.findElement(UserNameBox).sendKeys(Username);
    }
    public void insertemailaddress(String emailAddress){
        driver.findElement(SignupEmailaddressBox).sendKeys(emailAddress);
    }
    public SignUpPage clickonsignupbutton(){
        driver.findElement(signupButton).click();
        return new SignUpPage(driver);
    }
    public String geterromessege(){
        String Errormessage  = driver.findElement(errormessage).getText();
        return Errormessage ;
    }

}
