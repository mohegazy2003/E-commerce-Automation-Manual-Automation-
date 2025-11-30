package test;

import base.basetest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.DeleteAccountPage;
import pages.SignUpPage;
import pages.SingUploginPage;

public class Signuptest extends basetest {
    SingUploginPage singUploginPage ;

    @Test

    public void sign(){
        // HomePage
        singUploginPage = homePage.clickonloginSignupbutton();
        singUploginPage.insertUserName("MohamedWahid");
        singUploginPage.insertemailaddress("MohamedWahid32sa5@gmail.com");

        // SignupPage

       SignUpPage signUpPage =singUploginPage.clickonsignupbutton();
        signUpPage.clickonMrsButton();
        signUpPage.clickonMrButton();
        signUpPage.insertpassword("123abc");
        signUpPage.insertday("12");
        signUpPage.insertmonth("may");
        signUpPage.insertyears("2000");
        signUpPage.clickonSignUpForOurNewsletter();
        signUpPage.clickonReceiveSpecialOffersFromOurPartners();
        signUpPage.insertFristName("mohamed");
        signUpPage.insertLastName("Wahid");
        signUpPage.insertcompany("amit");
        signUpPage.insertaddress("Street 10");
        signUpPage.insertaddress1("Building 5");
        signUpPage.insertcountry("india");
        signUpPage.insertstate("Cairo");
        signUpPage.insertcity("cairo");
        signUpPage.insertZipcode("11835");
        signUpPage.insertmobilenumber("01123456789");

        //AccountCreatedPage
        AccountCreatedPage accountCreatedPage = signUpPage.clickoncreatAccount();
        String accual = accountCreatedPage.getconmessage();
        String accpect = "Congratulations! Your new account has been successfully created!";



        //assertion
       Assert.assertTrue(accual.contains(accpect));

        homePage =accountCreatedPage.clickoncontinuebutton();

        //HomePage
        DeleteAccountPage deleteAccountPage = homePage.clickonremoveaccont();
        // DeleteAccountPage
        String accual1 = deleteAccountPage.getdeleteaccountMessage();
        String accpect2 = "Account Deleted!" ;

        //Assertion
        //Assert.assertTrue(accual1.contains(accpect2));

    }
    @Test
    public void checktest(){
        singUploginPage = homePage.clickonloginSignupbutton();
        singUploginPage.insertUserName("mohamedwahid");
        singUploginPage.insertemailaddress("mohamedwahid@gmail.com");
        singUploginPage.clickonsignupbutton();
        String accual3 = singUploginPage.geterromessege();
        String acppect3 = "Email Address already exist!" ;
        Assert.assertTrue(accual3.contains(acppect3));



    }

}
