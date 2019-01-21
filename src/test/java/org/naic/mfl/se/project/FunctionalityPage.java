package org.naic.mfl.se.project;
import org.naic.mfl.se.utils.ConstantValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class FunctionalityPage extends BasePage {
    public FunctionalityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login")
    private WebElement signIn;

    @FindBy(id = "email_create")
    private WebElement email;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccount;

    @FindBy(id = "id_gender2")
    private WebElement gender;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "company" )
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "other")
    private WebElement other;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(className = "account")
    private WebElement account;

    @FindBy(className = "info-account")
    private WebElement infoAccount;

    @FindBy(className = "logout")
    private WebElement logout;

    @FindBy(id = "email")
    private WebElement loginEmail;

    @FindBy(id = "passwd")
    private WebElement loginPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement loginSubmit;

    @FindBy(linkText = "Women")
    private WebElement women;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement costume;

    @FindBy(xpath = "//*[@id='buy_block']/div/div[3]/div/p")
    private WebElement submit;

    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkOut;

    @FindBy(name = "processAddress")
    private WebElement processAddress;

    @FindBy(id = "uniform-cgv")
    private WebElement unifornCGV;

    @FindBy(name = "processCarrier")
    private WebElement processCarrier;

    @FindBy(className = "bankwire")
    private WebElement bankWire;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement cart;

    @FindBy(xpath = "//span[text()='Register']")
    private WebElement registerAccount;

    @FindBy(xpath = "//*[text()='Sign out']")
    private WebElement signOut;

    @FindBy(xpath = "//*[starts-with(@id ,'fancybox')]")
    private WebElement frameElement;



    public void clickSignIn(){
        signIn.click();
        waitForElementVisible(email,30);
    }

    public void enterEmail(String emailId){
        email.clear();
        email.sendKeys(emailId);
    }

    public void clickCreateAccount(){
        createAccount.submit();
        waitForElementVisible(gender,30);
    }

    public void registerForm(Map<String, String> userDetails){
        ConstantValues.setValue("firstName",userDetails.get("firstName"));
        firstName.sendKeys((String)userDetails.get("firstName"));
        ConstantValues.setValue("lastName",userDetails.get("lastName"));
        lastName.sendKeys((String)userDetails.get("lastName"));
        password.sendKeys((String)userDetails.get("password"));
        selectDay((String)userDetails.get("day"));
        selectMonth((String)userDetails.get("month"));
        selectYear((String)userDetails.get("year"));
        company.sendKeys((String)userDetails.get("company"));
        address1.sendKeys((String)userDetails.get("address1"));
        address2.sendKeys((String)userDetails.get("address2"));
        city.sendKeys((String)userDetails.get("city"));
        selectCountry((String)userDetails.get("country"));
        selectState((String)userDetails.get("state"));
        postcode.sendKeys((String)userDetails.get("postalCode"));
        other.sendKeys((String)userDetails.get("others"));
        phone.sendKeys((String)userDetails.get("phone"));
        phone_mobile.sendKeys((String)userDetails.get("mobile"));
        alias.sendKeys((String)userDetails.get("alias"));
        submitAccount.click();
    }

    public void selectDay(String day){
        Select ds = new Select(days);
        ds.selectByValue(day);
    }

    public void selectMonth(String month){
        Select sm = new Select(months);
        sm.selectByValue(month);
    }

    public void selectYear(String year){
        Select sy = new Select(years);
        sy.selectByValue(year);
    }

    public void selectCountry(String countryName){
        Select sc = new Select(country);
        sc.selectByVisibleText(countryName);
    }

    public void selectState(String stateName){
        Select ss = new Select(state);
        ss.selectByVisibleText(stateName);
    }

    public void clickSubmitAccount(){
        submitAccount.submit();
        waitForVisibilityOdElementLocated(By.cssSelector("h1"),15);
    }

    public void clickSignOut(){
        signOut.click();
    }


    public void verifySignUp(WebDriver driver){
        WebElement header = driver.findElement(By.cssSelector("h1"));
      assertTrue(header.getText().equalsIgnoreCase("MY ACCOUNT"));
      assertTrue(account.getText().equalsIgnoreCase((String) ConstantValues.getValue("firstName")+" "+(String)ConstantValues.getValue("lastName")));
    assertTrue(infoAccount.getText().contains("Welcome to your account."));
    assertTrue(logout.isDisplayed());
     assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    public void login(String userName,String password){
        loginEmail.sendKeys(userName);
        loginPassword.sendKeys(password);
        loginSubmit.click();
        waitForVisibilityOdElementLocated(By.cssSelector("h1"),15);
    }

    public void getShoppingInfo() throws InterruptedException {
        waitForElementVisible(women,15);
        women.click();
        waitUntilElementToBeClickable(costume,15);
        costume.click();
        Thread.sleep(1000);
       driver.switchTo().frame(frameElement);
        submit.click();
        waitForElementVisible(checkOut,15);
        checkOut.click();
        waitForElementVisible(checkOut,10);
        checkOut.click();
        waitForElementVisible(processAddress,15);
        processAddress.click();
        waitForElementVisible(unifornCGV,15);
        unifornCGV.click();
        processCarrier.click();
        waitForElementVisible(bankWire,15);
        bankWire.click();
        waitForElementVisible(cart,15);
        cart.click();
    }

    public void verifyCart(WebDriver driver){
        waitForVisibilityOdElementLocated(By.cssSelector("h1"),15);
        WebElement header = driver.findElement(By.cssSelector("h1"));
        assertTrue("ORDER CONFIRMATION".equalsIgnoreCase(header.getText()));
       assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
      assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
    }

}