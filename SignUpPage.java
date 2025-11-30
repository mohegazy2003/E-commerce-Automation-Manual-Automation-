package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver =driver;
    }
    // *locator*

    //Enter Account Information
    private By Mrbutton = By.cssSelector("input[value='Mr']");
    private By Mrsbutton = By.cssSelector("input[value='Mrs']");
    private By passwordBox = By.id("password");
    private By daysbox = By.cssSelector("select[name='days']");
    private By monthsbox = By.cssSelector("select[name='months']");
    private By yearssbox = By.cssSelector("select[name='years']");
    private By SignUpForOurNewsletter = By.cssSelector("input[name='newsletter']");
    private By ReceiveSpecialOffersFromOurPartners = By.cssSelector("input[name='optin']");

    //Address Information
    private By fristNamebox = By.cssSelector("input[name='first_name']");
    private By lastNamebox = By.cssSelector("input[name='last_name']");
    private By address1Box = By.cssSelector("input[name='address1']");
    private By companyname = By.cssSelector("input[name='company']");
    private By address2Box = By.cssSelector("input[name='address2']");
    private By countryBox = By.cssSelector("select[name='country']");
    private By stateBox = By.cssSelector("input[name='state']");
    private By CityBox = By.cssSelector("input[name='city']");
    private By zipBox = By.cssSelector(" input[id='zipcode']");
    private By mobilenumberBox = By.cssSelector("input[name='mobile_number']");
    private By createAccount = By.cssSelector("button[type='submit']");







    //*Action*

    //Enter Account Information
    public void clickonMrButton(){
        driver.findElement(Mrbutton).click();
    }
    public void clickonMrsButton(){
        driver.findElement(Mrsbutton).click();
    }
    public void insertpassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }
    public void insertday(String day){
        driver.findElement(daysbox).sendKeys(day);

    }
    public void insertmonth(String month){
        driver.findElement(monthsbox).sendKeys(month);
    }
    public void insertyears(String year){
        driver.findElement(yearssbox).sendKeys(year);

    }
    public void clickonSignUpForOurNewsletter(){
        driver.findElement(SignUpForOurNewsletter).click();
    }
    public void clickonReceiveSpecialOffersFromOurPartners(){
        driver.findElement(ReceiveSpecialOffersFromOurPartners).click();
    }

    //Address Information
    public void insertFristName(String fristname){
        driver.findElement(fristNamebox).sendKeys(fristname);
    }
    public void insertLastName(String Lastname){
        driver.findElement(lastNamebox).sendKeys(Lastname);
    }

    public void insertaddress1(String address1){
        driver.findElement(address1Box).sendKeys(address1);
    }
    public void insertcompany(String company){
        driver.findElement(companyname).sendKeys(company);
    }
    public void insertaddress(String address2){
        driver.findElement(address2Box).sendKeys(address2);
    }
    public void insertcountry(String country){
        driver.findElement(countryBox).sendKeys(country);
    }
    public void insertstate(String state){
        driver.findElement(stateBox).sendKeys(state);
    }
    public void insertcity(String city){
        driver.findElement(CityBox).sendKeys(city);
    }
    public void insertZipcode(String zipcode){
        driver.findElement(zipBox).sendKeys(zipcode);
    }
    public void insertmobilenumber(String mobilenumber){
        driver.findElement(mobilenumberBox).sendKeys(mobilenumber);
    }
    public AccountCreatedPage clickoncreatAccount(){
        driver.findElement(createAccount).click();
        return new AccountCreatedPage(driver);
    }















}
