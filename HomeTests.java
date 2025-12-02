package tests;

import base.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class HomeTests extends BaseClass {

    private String generateUniqueEmail() {
        return "testuser" + System.currentTimeMillis() + "@test.com";
    }

    @Test
    public void homePageLoadsTest() {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Automation Exercise"));
        Assert.assertTrue(homePage.getPageTitle().contains("Automation Exercise"),
                "Home page title does not match.");
    }


    @Test
    public void validSubscriptionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.enterSubscriptionEmail(generateUniqueEmail());
        homePage.clickSubscribe();

        String expectedMessage = "You have been successfully subscribed!";
        Assert.assertEquals(homePage.getSubscriptionSuccessMessage(), expectedMessage,
                "Subscription success message is incorrect or not displayed.");
    }

    @Test
    public void featuredProductsDisplayedTest() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getFeaturesSection().isDisplayed(),
                "The 'FEATURES_ITEMS' section is not displayed.");
    }
}
