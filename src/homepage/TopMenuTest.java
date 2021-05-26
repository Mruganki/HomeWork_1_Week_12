package homepage;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
      public String baseurl = "https://demo.nopcommerce.com/n";

    public void selectMenu(String menu){
        menu="Computers";
            openBrowser(baseurl);
       // clickOnElement();
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

    }
    @Test
    public void verifyPageNavigation(){

        selectMenu ("Computers");

        String expectedcomputer = "Computer";
        WebElement actualcomputer = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualcomputermessaage = actualcomputer.getText();
        Assert.assertEquals("User is on computer page",expectedcomputer,actualcomputermessaage);


    }


}
