package Test;

import Base.BaseTest;
import Page.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {
    ContactUsPage contactUsPage;

    @Test(priority = 1)
    public void EnterDatavalid() {

        contactUsPage = homePage.ClickOnContactUs();
        contactUsPage.insertName("Hager Waheed");
        contactUsPage.insertEmail("Hagerwaheed002@gmail.com");
        contactUsPage.insertMessage("VeryGood");
        contactUsPage.insertSubject("qqqqqqqqqqqqqqwerrrrrrrrrrxcvbbbbbbbbbbb");
        contactUsPage.ClickOnSubmit();
        contactUsPage.acceptAlert();

        //assertion
        String Actualresult = contactUsPage.getSuccessmessage();
        String expectedResult = "Success! Your details have been submitted successfully.";
        Assert.assertTrue(Actualresult.contains(expectedResult));

    }


    @Test(priority = 2)
    public void EnterInvalidEmail() {

        contactUsPage = homePage.ClickOnContactUs();
        contactUsPage.insertName("Hager Waheed");
        contactUsPage.insertEmail("Ha1752r1gwuj");
        contactUsPage.insertMessage("VeryGood");
        contactUsPage.insertSubject("qqqqqqqqqqqqqqwerrrrrrrrrrxcvbbbbbbbbbbb");
        contactUsPage.ClickOnSubmit();

        String actualError = contactUsPage.getEmailErrorMessage();
        String expected = "Please include an'@'in the email address.'Ha1752r1gwuj'is missing an'@'.";
        Assert.assertTrue(actualError.contains(expected),
                "Email error message is not correct: " + actualError);
    }
    @Test(priority = 3)
    public void invaliddata() {

        contactUsPage = homePage.ClickOnContactUs();
        contactUsPage.insertName("");
        contactUsPage.insertEmail("Hagerwaheed002@gmail.com");
        contactUsPage.insertMessage("VeryGood");
        contactUsPage.insertSubject("qqqqqqqqqqqqqqwerrrrrrrrrrxcvbbbbbbbbbbb");
        contactUsPage.ClickOnSubmit();
        contactUsPage.acceptAlert();

        //assertion
        String Actualresult = contactUsPage.getSuccessmessage();
        String expectedResult = "Success! Your details have been submitted successfully.";
        Assert.assertTrue(Actualresult.contains(expectedResult));

    }
    }
