package computer;

import browserTesting.BaseTest;
import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Base64;

public class TestSuite extends BaseTest {

    @Before
    public void verifyProductArrangeInAlphaBaticalOrder() {
        String baseurl = "https://demo.nopcommerce.com/";
        openBrowser(baseurl);
        Actions action = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        action.moveToElement(computer).moveToElement(desktop).click().build().perform();
        WebElement sortby = driver.findElement(By.id("products-orderby"));
        Select select = new Select(sortby);
        select.selectByValue("6");
        String expectedtext = "Name: Z to A";
        WebElement actualdriver = driver.findElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        String actualtext = actualdriver.getText();
        Assert.assertEquals("Products not in Decedning order", expectedtext, actualtext);
    }

       @Test
     public void verifyProductAddedToShoppingCartSucessFully()throws InterruptedException{

           WebElement sortby = driver.findElement(By.id("products-orderby"));
           Select select = new Select(sortby);
           select.selectByValue("5");
           Thread.sleep(3000);
           clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
           String expectedTextOnPage = "Build your own computer";
           WebElement actualdriver = driver.findElement(By.xpath("//h1[text()='Build your own computer']"));
           String actualTextOnPage = actualdriver.getText();
           Assert.assertEquals("You are not on Build Your Own Computer Page",expectedTextOnPage,actualTextOnPage);
           //Thread.sleep(3000);
           WebElement dropdown = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
           select = new Select(dropdown);
           select.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
           WebElement dropdw = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
           select = new Select(dropdw);
           select.selectByVisibleText("8GB [+$60.00]");
           clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
           clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
           clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
           String expectedvalue = "$1,475.00";
           WebElement actualdrivers = driver.findElement(By.xpath("//span[text()='$1,475.00']"));
           String actualvalue = actualdrivers.getText();
           Assert.assertEquals("Total is not as expected",expectedvalue,actualvalue);
           clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
           String expectedmessage = "The product has been added to your shopping cart";//
           WebElement actulmessdriver= driver.findElement(By.xpath("//p[@class='content']"));// popup link path
           String actualmessage = actulmessdriver.getText();
           Assert.assertEquals("The product has been added to your ",expectedmessage,actualmessage);
           clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));//click on X button
           Actions actions = new Actions(driver);
           WebElement shoppingcart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
           actions.moveToElement(shoppingcart).build().perform();
           clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
           String expectedmsg = "Shopping cart";
           WebElement actualdrivermsg = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
           String actualmsg = actualdrivermsg.getText();
           Assert.assertEquals("Your are not on Shopping cart page",expectedmsg,actualmsg);
           driver.findElement(By.xpath("//input[@value='1']")).clear();
           Thread.sleep(3000);
           driver.findElement(By.xpath("//input[@value='1']")).sendKeys("2");
           clickOnElement(By.xpath("//button[text()='Update shopping cart']"));
           String expectedamt = "$2,950.00";
           WebElement actualdriveramt = driver.findElement(By.xpath("//tbody/tr[4]/td[2]/span[1]"));
           String actualamt = actualdriveramt.getText();
           Assert.assertEquals("Total not matched with actual amt",expectedamt,actualamt);
           Thread.sleep(3000);
           clickOnElement(By.id("termsofservice"));
           clickOnElement(By.id("checkout"));
           String expctdmsg = "Welcome, Please Sign In!";
           WebElement actuldrv = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
           String actulmsg = actuldrv.getText();
           Assert.assertEquals("Error messge : you'r not on checkout page",expctdmsg,actulmsg);
           Thread.sleep(3000);
           clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));
           Thread.sleep(3000);
           driver.findElement(By.xpath("//input[@name='BillingNewAddress.FirstName']")).sendKeys("Sonia");
           driver.findElement(By.xpath("//input[@name='BillingNewAddress.LastName']")).sendKeys("Marek");
           driver.findElement(By.xpath("//input[@name='BillingNewAddress.Email']")).sendKeys("sonmrk30@gmail.com");
           WebElement drpdown = driver.findElement(By.id("BillingNewAddress_CountryId"));
           Select select2 = new Select(drpdown);
           select2.selectByValue("233");
           driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
           driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("235 a, Healton Road");
           driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA4 5DF");
           driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0208 3256 8989");
           driver.findElement(By.id("billing-buttons-container")).click();
           clickOnElement(By.id("shippingoption_1"));//click on nextdayair
           clickOnElement(By.id("shipping-method-buttons-container"));
           clickOnElement(By.id("paymentmethod_1"));
           clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']"));
           WebElement carddropdown = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
           Select select13= new Select(carddropdown);
           select13.selectByValue("MasterCard");
           driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Sonia Marek");
           driver.findElement(By.id("CardNumber")).sendKeys("5555555555554444");
           WebElement expmonDropdown = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
           Select select4 = new Select(expmonDropdown);
           select4.selectByValue("10");
           WebElement expyrDropdown = driver.findElement(By.id("ExpireYear"));
           Select select5 = new Select(expyrDropdown);
           select5.selectByValue("2027");
           driver.findElement(By.id("CardCode")).sendKeys("588");
           clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']"));
          String expectedtxt = "Payment Method: Credit Card";
          WebElement actualtxtdriver = driver.findElement(By.xpath("//li[@class='payment-method']"));
          String actualtxt = actualtxtdriver.getText();
          Assert.assertEquals("Please check your payment method",expectedtxt,actualtxt);
           String exptxt = "Shipping Method: Next Day Air";
           WebElement actultxtdriver = driver.findElement(By.xpath("//li[@class='shipping-method']"));
           String actultxt = actultxtdriver.getText();
           Assert.assertEquals("Please check your payment method",exptxt,actultxt);
           String expttotal = "Total: $2,950.00";
           WebElement actultotaldriver = driver.findElement(By.xpath("//tr[@class='order-total']"));
           String actultotal = actultotaldriver.getText();
           Assert.assertEquals("Please check your payment method",expttotal,actultotal);
           clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
           String exptextIS = "Thank you";
           WebElement actualtextIS = driver.findElement(By.xpath("//h1[text()='Thank you']"));
           String actultotalIS = actualtextIS.getText();
           Assert.assertEquals("Please check your Process",exptextIS,actultotalIS);
           String exptxtIS = "Your order has been successfully processed!";
           WebElement actualtxtIS = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
           String actultxtIS = actualtxtIS.getText();
           Assert.assertEquals("Please check your Process",exptxtIS,actultxtIS);
           clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));
           String exeptxtIS = "Welcome to our store";
           WebElement actltxtIS = driver.findElement(By.xpath("//h2[text()='Welcome to our store']"));
           String acltxtIS = actltxtIS.getText();
           Assert.assertEquals("Please check your Endresult",exeptxtIS,acltxtIS);
       }

       @After
       public void tearDown(){

        closedBrowser();
       }

}





