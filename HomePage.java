package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

      //Locators
     private By ClickOnContactUs= By.linkText("Contact us");

    //Actions
    public ContactUsPage ClickOnContactUs(){
        driver.findElement(ClickOnContactUs).click();
        return new ContactUsPage(driver);

    }


}

