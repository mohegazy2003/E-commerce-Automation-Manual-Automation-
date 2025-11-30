package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    WebDriver driver;
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver ;
    }
    // locator

    private By  conmessage = By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]");
    private By continuebutton = By.cssSelector(".btn.btn-primary");

    //Action
    public String getconmessage(){
        String AccountCreatedmessage = driver.findElement(conmessage).getText();
        return AccountCreatedmessage;

    }
    public HomePage clickoncontinuebutton(){
        driver.findElement(continuebutton).click();
        return new HomePage(driver);
    }


}
