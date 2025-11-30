package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver ;
    public HomePage(WebDriver driver) {
        this.driver =driver ;
    }
    //locter
    private By loginSignupage = By.xpath("//a[normalize-space()='Signup / Login']");
    private By deleteAccount = By.xpath("(//a[@style='color:brown;'])[2]");



    //Acction

    public SingUploginPage clickonloginSignupbutton(){
    driver.findElement(loginSignupage).click();
    return new SingUploginPage(driver);
    }
    public DeleteAccountPage clickonremoveaccont(){
        driver.findElement(deleteAccount).click();
        return new DeleteAccountPage(driver);
    }



    }
