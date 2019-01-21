package org.naic.mfl.se.challenge;

import org.naic.mfl.se.project.FunctionalityPage;
import org.naic.mfl.se.project.DriverFactory;
import org.naic.mfl.se.utils.Util;
import org.naic.mfl.se.utils.ConstantValues;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebTest {

    public WebDriver driver = DriverFactory.getDriver();
    private FunctionalityPage functionalityPage = new FunctionalityPage(driver);

    @BeforeTest
    @Parameters({"url"})
    public void setUp(String url){
        System.out.println("cvcbvvnbvbnb");
        functionalityPage.url(url);
    }

    @Test
    @Parameters({"emailId","firstName","lastName","password","day","month","year","company","address1","address2","city","state","postalCode","others","phone","mobile","alias","country"})
    public void signInFunctionality(String emailId, String firstName,String lastName,String password,String day,String month,String year, String company,String address1,String address2,String city,String state,String postalCode,String others,String phone,String mobile, String alias,String country){
        if (functionalityPage == null){
            functionalityPage = new FunctionalityPage(DriverFactory.getDriver());
        }
        functionalityPage.clickSignIn();
        String emailID = emailId+Util.getCurrentTime()+"@gmail.com";
        functionalityPage.enterEmail(emailID);
        ConstantValues.setValue("userMailid",emailID);
        functionalityPage.clickCreateAccount();
        Map<String,String> userDetails = new HashMap<String, String>();
        userDetails.put("firstName",firstName);
        userDetails.put("lastName",lastName);
        userDetails.put("password",password);
        userDetails.put("day",day);
        userDetails.put("month",month);
        userDetails.put("year",year);
        userDetails.put("company",company);
        userDetails.put("address1",address1);
        userDetails.put("address2",address2);
        userDetails.put("city",city);
        userDetails.put("state",state);
        userDetails.put("postalCode",postalCode);
        userDetails.put("others",others);
        userDetails.put("phone",phone);
        userDetails.put("mobile",mobile);
        userDetails.put("alias",alias);
        userDetails.put("country",country);
        functionalityPage.registerForm(userDetails);
        functionalityPage.verifySignUp(driver);
    }

    @Test
    @Parameters({"password"})
    public void loginFunctionality(String password){
        functionalityPage.clickSignOut();
        String email = (String) ConstantValues.getValue("userMailid");
        functionalityPage.login(email,password);
        functionalityPage.verifySignUp(driver);
    }

    @Test
    @Parameters({"password"})
    public void checkOutFunctionality(String password) throws InterruptedException {
        functionalityPage.getShoppingInfo();
        functionalityPage.verifyCart(driver);
    }

    @AfterTest
    public void closingSeleniumDriver() {
        driver.quit();
    }
}