package org.naic.mfl.se.project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverFactory {
        private static WebDriver driver;

        public static WebDriver initializeWebDriver(){
            String chromeDriverPath = Constants.CHROME_DRIVER;
            System.setProperty("webdriver.chrome.driver",chromeDriverPath);
            driver = new ChromeDriver();
            return driver;
        }

        public static WebDriver getDriver(){
            if(driver == null){
                driver = initializeWebDriver();
            }
            return driver;
        }

        public static void killDriver(){
            if (driver != null){
                driver.close();
                driver.quit();
            }
        }
    }

