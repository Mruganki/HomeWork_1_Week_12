package browserTesting;

import Utility.Utility;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class BaseTest extends Utility {

    public void openBrowser(String baseurl) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");// key ,(driverpath) value as required in setproperty
        driver = new ChromeDriver();// driver object in ChromeDriver class to operate different functionality of webpage
        driver.manage().window().maximize();//driver object used to maximise window from manage functionality
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);// driver object used to manage timeout waiting period implicity for  webpage
        driver.get(baseurl);// driver object used to get (access) given url

    }

    public void closedBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}