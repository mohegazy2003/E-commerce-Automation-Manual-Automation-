package Page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;
    WebDriverWait Wait;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

    }

    //locator
    private By NameBox = By.name("name");
    private By EmailBox = By.name("email");
    private By SubjectBox = By.name("subject");
    private By YourMessageBox = By.name("message");
    private By FeedBackLink = By.xpath("//*[@id=\"contact-page\"]/div[3]/div[2]/div/address/p[2]/a/u");
    private By SubmitButton = By.name("submit");
    private By Successmessage = By.cssSelector(".status.alert.alert-success");
    private By EmailErrorMessage = By.cssSelector("div.alert.alert-danger");

    //Actions
    public void insertName(String name) {
        driver.findElement(NameBox).sendKeys(name);
    }

    public void insertEmail(String email) {
        driver.findElement(EmailBox).sendKeys(email);
    }

    public void insertSubject(String subject) {
        driver.findElement(SubjectBox).sendKeys(subject);
    }

    public void insertMessage(String message) {
        driver.findElement(YourMessageBox).sendKeys(message);
    }

    public void ClickOnSubmit() {
        driver.findElement(SubmitButton).click();
    }

    public void ClickOnFeedBackLink() {
        driver.findElement(FeedBackLink).click();

    }

    public void Wait() {
        Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getSuccessmessage() {
        String message = driver.findElement(Successmessage).getText();
        return message;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getEmailErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMessage));
        return driver.findElement(EmailErrorMessage).getText();
    }






}

