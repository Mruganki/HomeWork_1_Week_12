package electronics;

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

public class ElectronicsTest extends BaseTest {

    @Before
    public void verifyUserShouldNavigatetoCellphonesPageSiccessfully() {
        String baseurl = "https://demo.nopcommerce.com/";
        openBrowser(baseurl);
        Actions action = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphone = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        action.moveToElement(electronics).moveToElement(cellphone).click().build().perform();
        String expectedCellPhoneText = "Cell phones";
        String actualCellPhoneText = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        Assert.assertEquals("Customer Is Not On Cellphone page", expectedCellPhoneText, actualCellPhoneText);
    }

    @Test
    public void verifyThatTheProductAddedsuccessfullyAndPlaceOrderSucessfully() throws InterruptedException {

        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[text()='Nokia Lumia 1020']")); // click on phone
        String expNokia = "Nokia Lumia 1020";
        String actNokia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("You have selected wrong phone", expNokia, actNokia);
        String expPriceDisplayed = "$349.00";
        String actPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("price for Phone Is Wrong", expPriceDisplayed, actPrice);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.id("add-to-cart-button-20"));               //add to cart button
        String topbarMessage = "The product has been added to your shopping cart";
        String realTopBarMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("product Not Added To The Cart", topbarMessage, realTopBarMessage);
        clickOnElement(By.xpath("//span[@class='close']"));
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));//mousehover on shopping cart
        clickOnElement(By.xpath("//button[text()='Go to cart']"));           //click on go to cart
        String shoppingCartPage = "Shopping cart";             //assert for shopping cart
        String actualShoppingCartPage = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("Shopping Cart Page Is Not Displayed", shoppingCartPage, actualShoppingCartPage);
        String quantity = "(2)";                //assert for quantity 2
        String actualQuantity = getTextFromElement(By.xpath("//span[@class='cart-qty']"));
        Assert.assertEquals("The Quantity Is Incorrect",quantity,actualQuantity);
        String expectedTotal = "$698.00";
        String acutalTotal = getTextFromElement(By.xpath("//span[text()='$698.00']"));
        Assert.assertEquals("Total Is Incorrect", expectedTotal, acutalTotal);
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice")); //i agree checkbox
        clickOnElement(By.id("checkout"));        //checkout button
        String expectedVerifyWelcome = "Welcome, Please Sign In!";
        String realwelcomeText = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome Message Is Wrong", expectedVerifyWelcome, realwelcomeText);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        String registerText = "Register";
        String actualRegisterText = getTextFromElement(By.xpath("//h1[text()='Register']"));
        Assert.assertEquals("User Is Not On Registration Page", registerText, actualRegisterText);
        Thread.sleep(2000);
        sendTextToElement(By.id("FirstName"), "Soophi");   //firstname
        sendTextToElement(By.id("LastName"), "Clark");   //lastname
        sendTextToElement(By.id("Email"), "sclark40@gmail.com"); //email id has to be changed before running
        sendTextToElement(By.id("Password"), "happydays");  //password
        sendTextToElement(By.id("ConfirmPassword"), "happydays");//confirm password
        clickOnElement(By.id("register-button"));                                    //register button
        String registerComplete = "Your registration completed";
        String actualRegistrationText = getTextFromElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals("User Registration Is Not Completed", registerComplete, actualRegistrationText);
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        String expectedCartText = "Shopping cart";
        String actuaCartText = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("User Is Not on Shopping Cart page", expectedCartText, actuaCartText);
        Thread.sleep(1000);
        clickOnElement(By.id("termsofservice"));  //click I agree,again
        clickOnElement(By.id("checkout"));      //click checkout,again
        selectByvalueFromDropDown(By.id("BillingNewAddress_CountryId"), "157");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_City"), "Wellington");   //city
        sendTextToElement(By.id("BillingNewAddress_Address1"), "42,Primley"); //address
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "987681"); //zip code
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "786582"); //phone number
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));       //click on contnue button
        clickOnElement(By.id("shippingoption_2"));          //click on radio button
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));  //click on continue button
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        selectByvalueFromDropDown(By.id("CreditCardType"), "visa");
        sendTextToElement(By.id("CardholderName"), "Mr.S Clark");  //name on card
        sendTextToElement(By.id("CardNumber"), "4539926921009583"); //card number
        selectByvalueFromDropDown(By.id("ExpireMonth"), "7"); //month
        selectByvalueFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "449");            //cvc cardcode
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));         //click on continue
        String paymentCard = "Payment Method: Credit Card";
        String actualPaymentCard = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals("Payment method Is Wrong", paymentCard, actualPaymentCard);
        String shippingMethod = "Shipping Method: 2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals("Shipping method is Incorrect", shippingMethod, actualShippingMethod);
        String totalOrder = "Total: $698.00";
        String actualTotalOrder = getTextFromElement(By.xpath("//tr[@class='order-total']"));
        Assert.assertEquals("Total Order Is Wrong", totalOrder, actualTotalOrder);
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));    //click on continue
        String thanks = "Thank you";
        String actualThanksPage = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Thank you Page Not Displayed", thanks, actualThanksPage);
        String orderConfirmation = "Your order has been successfully processed!";
        String realorderConfirmation = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertEquals("Order Has Not Been Confirmed", orderConfirmation, realorderConfirmation);
        clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));  //last continue click
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        Assert.assertEquals("User Is Not On Main Page", expectedWelcomeMessage, actualWelcomeMessage);
        clickOnElement(By.xpath("//a[@class='ico-logout']"));
        String url = "https://demo.nopcommerce.com/";
        String realUrl = driver.getCurrentUrl();
        Assert.assertEquals("Wrong Url", url, realUrl);

    }
    @After
    public void tearDown(){

        closedBrowser();
    }


}











































