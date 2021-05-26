package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {

    public WebDriver driver;


    /**
     * This method witll click on element
     * @param by
     */
     public void clickOnElement(By by){
         driver.findElement(by).click();

    }

    /**
     * this method will get text from element
     *
     * @return
     */
    public String getTextFromElement(By by){

         return driver.findElement(by).getText();

    }

    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);


    }

    /**
     * this method will selct by value from dropdown
     * @param by
     * @param value
     */
    public void selectByvalueFromDropDown(By by,String value){

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();

    }



}
