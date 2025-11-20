package First_project.login;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login extends BaseTest {
    @Test (priority = 1) 
    public void testLogin(){



        //Login Scenario
        driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("mahmoud100@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();




    }
    @Test (priority = 2)
    public void testIncorrectUsername(){



        //Login with incorrect username
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("mahmoud@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //Assertion
        String actualResult = driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]")).getText();
        String expectedResult = "Your email or password is incorrect!";
        Assert.assertTrue(actualResult.contains(expectedResult));

}
    @Test (priority = 3)
    public void testIncorrectPassword(){



        //Login with incorrect password
        driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("mahmoud100@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //Assertion
        String actualResult = driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]")).getText();
        String expectedResult = "Your email or password is incorrect!";
        Assert.assertTrue(actualResult.contains(expectedResult));

}
}
