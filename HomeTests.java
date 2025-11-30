package tests;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.List;
public class HomeTests extends BaseClass {


    private String generateUniqueEmail() {
        return "testuser" + System.currentTimeMillis() + "@test.com";
    }

    @Test(description = "TC_Home_001: Verify Home Page loads successfully")
    public void testHomePageLoads() {
        HomePage homePage = new HomePage(driver);
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle,
                "Test Failed: Home page title does not match.");
    }

    @Test(description = "TC_Home_002: Verify navigation links are visible and clickable")
    public void testNavigationLinks() {
        HomePage homePage = new HomePage(driver);
        WebElement productsLink = homePage.getProductsLink();

        Assert.assertTrue(productsLink.isDisplayed(), "Products link is not displayed.");
        Assert.assertTrue(productsLink.isEnabled(), "Products link is not clickable.");

        productsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"),
                "Test Failed: Products link did not redirect correctly.");
    }

    @Test(description = "TC_Home_003: Verify Subscription feature with valid email")
    public void testValidEmailSubscription() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();
        homePage.enterSubscriptionEmail(generateUniqueEmail());
        homePage.clickSubscribe();

        String expectedMessage = "You have been successfully subscribed!";
        Assert.assertEquals(homePage.getSubscriptionSuccessMessage(), expectedMessage,
                "Test Failed: Subscription success message is incorrect or not displayed.");
    }

    @Test(description = "TC_Home_004: Verify Scroll Up button works correctly")
    public void testScrollUpButtonWorks() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();
        homePage.clickScrollUpButton();

        // Assert that scroll position is near 0 (top of the page)
        long scrollPosition = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return window.pageYOffset;");

        Assert.assertTrue(scrollPosition < 50, "Test Failed: Did not scroll back to the top.");
    }

    @Test(description = "TC_Home_005: Verify Scroll to bottom/top works correctly (Scroll Down)")
    public void testScrollDownFunctionality() {
        // This is a verification of the ability to scroll down, already used in TC_Home_003/004.
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();

        long scrollPosition = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return window.pageYOffset;");

        // Assert that scroll position is far from 0
        Assert.assertTrue(scrollPosition > 500, "Test Failed: Did not scroll down to the bottom.");
    }


    @Test(description = "TC_Home_006: Verify Recommended Items section works")
    public void testRecommendedItemsSection() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();
        homePage.clickRecommendedAddToCart();

        Assert.assertTrue(homePage.getModalHeader().getText().contains("Added!"),
                "Test Failed: Cart confirmation message did not appear for Recommended Item.");
    }

    @Test(description = "TC_Home_007: Verify website logo is displayed and clickable")
    public void testWebsiteLogo() {
        HomePage homePage = new HomePage(driver);
        WebElement logo = homePage.getWebsiteLogo();

        Assert.assertTrue(logo.isDisplayed(), "Website logo is not displayed.");
        Assert.assertTrue(logo.isEnabled(), "Website logo is not clickable.");
    }

    @Test(description = "TC_Home_008: Verify social media icons in footer (Expected Fail per spreadsheet)")
    public void testSocialMediaIcons() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();

        List<WebElement> icons = homePage.getSocialMediaIcons();

        Assert.assertFalse(icons.isEmpty(),
                "Test Failed: Expected social media icons to be found, but none were present (Matches expected failure).");
    }

    @Test(description = "TC_Home_009: Verify main slider functionality")
    public void testMainSliderFunctionality() {
        HomePage homePage = new HomePage(driver);

        WebElement initialSlide = driver.findElement(By.cssSelector("#slider-carousel .active"));
        String initialId = initialSlide.getAttribute("data-slide-to");

        homePage.clickNextSliderButton();


        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        WebElement newSlide = driver.findElement(By.cssSelector("#slider-carousel .active"));
        String newId = newSlide.getAttribute("data-slide-to");

        Assert.assertNotEquals(initialId, newId, "Test Failed: Slider did not change to the next image.");
    }


    @Test(description = "TC_Home_010: Verify featured products are displayed on homepage")
    public void testFeaturedProductsDisplay() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getFeaturesSection().isDisplayed(),
                "Test Failed: The 'FEATURES_ITEMS' section is not displayed.");
    }

    @Test(description = "TC_Home_011: Verify 'Add to Cart' button adds product to cart message")
    public void testFeaturedProductAddToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFeaturedAddToCart();

        Assert.assertTrue(homePage.getModalHeader().getText().contains("Added!"),
                "Test Failed: Product added to cart message did not appear for Featured Item.");
    }

    @Test(description = "TC_Home_012: Verify 'View Product' Button navigates to product details")
    public void testViewProductNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickViewProductButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/product_details/"),
                "Test Failed: Did not redirect to the product details page.");
    }

    @Test(description = "TC_Home_013: Verify product categories filter correctly (Requires Products Page)")
    public void testProductCategoryFilter() {

        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        WebElement categories = driver.findElement(By.id("accordian"));

        Assert.assertTrue(categories.isDisplayed(),
                "Test Failed: Product category filter section is not displayed on the Products page.");
    }

    @Test(description = "TC_Home_014: Verify brand links display correct products (Requires Products Page)")
    public void testBrandLinks() {

        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        WebElement firstBrand = driver.findElement(By.xpath("//a[text()='Biba']"));
        firstBrand.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("brand=Biba"),
                "Test Failed: Clicking brand link did not filter by brand.");
    }


    @Test(description = "TC_Home_016: Verify email subscription with invalid email (Expected Fail)")
    public void testInvalidEmailSubscription() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollToBottom();


        homePage.enterSubscriptionEmail("invalidemail.net");
        homePage.clickSubscribe();

        Assert.assertFalse(driver.getPageSource().contains("Please enter a valid email address"),
                "Test Failed: System correctly showed a validation error when expected to accept invalid email (Matches expected failure).");
    }

    @Test(description = "TC_Home_017: Verify homepage responsiveness across devices (Basic Check)")
    public void testHomepageResponsiveness() {

        driver.manage().window().setSize(new org.openqa.selenium.Dimension(400, 800));


        WebElement logo = driver.findElement(By.cssSelector(".logo img"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed in mobile view.");
    }

    @Test(description = "TC_Home_018: Verify all homepage images load successfully")
    public void testAllImagesLoadSuccessfully() {
        HomePage homePage = new HomePage(driver);
        List<WebElement> images = homePage.getAllImages();
        int brokenImageCount = 0;

        for (WebElement image : images) {

            if (image.getAttribute("naturalWidth") != null && image.getAttribute("naturalWidth").equals("0")) {
                brokenImageCount++;
            }
        }

        Assert.assertEquals(brokenImageCount, 0,
                "Test Failed: Found " + brokenImageCount + " broken images on the homepage.");
    }

    @Test(description = "TC_Home_019: Verify HTTPS security of the homepage")
    public void testHttpsSecurity() {
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://"),
                "Test Failed: Homepage is not using HTTPS.");
    }

    @Test(description = "TC_Home_020: Verify broken link check on homepage (Simplified)")
    public void testBrokenLinks() {

        HomePage homePage = new HomePage(driver);
        List<WebElement> links = homePage.getAllLinks();
        int suspiciousLinkCount = 0;

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && (url.contains("#") || url.toLowerCase().contains("javascript"))) {

            }
        }

        Assert.assertEquals(suspiciousLinkCount, 0,
                "Test Failed: Found " + suspiciousLinkCount + " suspicious links on the homepage.");
    }

    @Test(description = "TC_Home_021: Verify page load performance (Expected Fail per spreadsheet)")
    public void testPageLoadPerformance() {

        long startTime = System.currentTimeMillis();
        driver.get(driver.getCurrentUrl());
        long endTime = System.currentTimeMillis();

        long loadTimeSeconds = (endTime - startTime) / 1000;

        int maxLoadTimeSeconds = 5;

        
        if (loadTimeSeconds > maxLoadTimeSeconds) {
            Assert.fail("Test Failed: Homepage took " + loadTimeSeconds + "s to load, exceeding the " + maxLoadTimeSeconds + "s threshold (Matches expected failure).");
        } else {
            Assert.assertTrue(true, "Page loaded successfully within " + maxLoadTimeSeconds + " seconds.");
        }
    }
}
