package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HomePage {

    private WebDriver driver;


    private By headerLogo = By.cssSelector(".logo img");
    private By productsLink = By.xpath("//a[text()=' Products']");


    private By subscriptionEmailField = By.id("susbscribe_email");
    private By subscribeButton = By.id("subscribe");
    private By subscriptionSuccessMessage = By.id("success-subscribe");


    private By scrollUpButton = By.id("scrollUp");


    private By recommendedAddToCartButton = By.xpath("//div[@class='recommended_items']//a[contains(@class,'add-to-cart')]");


    private By socialMediaIcons = By.xpath("//div[@class='social-icons']/ul/li/a");


    private By sliderMain = By.id("slider-carousel");
    private By nextSlideButton = By.xpath("//a[@data-slide='next']");


    private By featuresSection = By.cssSelector(".features_items");
    private By featuredProductAddButton = By.xpath("(//div[@class='features_items']//a[text()='Add to cart'])[1]");
    private By viewProductButton = By.xpath("(//div[@class='features_items']//a[text()='View Product'])[1]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getProductsLink() {
        return driver.findElement(productsLink);
    }

    public WebElement getWebsiteLogo() {
        return driver.findElement(headerLogo);
    }


    public void scrollToBottom() {
        new Actions(driver).scrollByAmount(0, 10000).perform();
    }

    public WebElement getScrollUpButton() {
        return driver.findElement(scrollUpButton);
    }

    public void clickScrollUpButton() {
        driver.findElement(scrollUpButton).click();
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

    // Action methods for TC_Home_006, 008, 009, 010, 011
    public void clickRecommendedAddToCart() {
        driver.findElement(recommendedAddToCartButton).click();
    }

    public List<WebElement> getSocialMediaIcons() {
        return driver.findElements(socialMediaIcons);
    }

    public void clickNextSliderButton() {
        driver.findElement(nextSlideButton).click();
    }

    public WebElement getFeaturesSection() {
        return driver.findElement(featuresSection);
    }

    public void clickFeaturedAddToCart() {
        driver.findElement(featuredProductAddButton).click();
    }

    public void clickViewProductButton() {
        driver.findElement(viewProductButton).click();
    }


    public List<WebElement> getAllImages() {
        return driver.findElements(By.tagName("img"));
    }

    public List<WebElement> getAllLinks() {
        return driver.findElements(By.tagName("a"));
    }


    public WebElement getModalHeader() {
        return driver.findElement(By.cssSelector(".modal-content h4"));
    }
}