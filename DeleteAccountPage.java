package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage {
    WebDriver driver;
    public DeleteAccountPage(WebDriver driver) {
        this.driver=driver;
    }
    private By deleteaccountMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");

    //Action

    public String getdeleteaccountMessage(){
        String Deleteaccountmessage =driver.findElement(deleteaccountMessage).getText();
        return Deleteaccountmessage ;
    }
}
