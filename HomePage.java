package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By headerLogo = By.cssSelector(".logo");
    private By subscriptionEmailField = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By subscriptionSuccessMessage = By.id("success-subscribe");
    private By featuresSection = By.cssSelector(".features_items");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public WebElement getWebsiteLogo() {
        return driver.findElement(headerLogo);
    }

    public WebElement getFeaturesSection() {
        return driver.findElement(featuresSection);
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailField).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscribeButton).click();
    }

    public String getSubscriptionSuccessMessage() {
        return driver.findElement(subscriptionSuccessMessage).getText();
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}

