package Pages;

import Main.Base;
import Main.Singleton;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.NoSuchElementException;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    public static String name = "Avi";
    public static WebElement element;
    String timeNow = String.valueOf(System.currentTimeMillis());


    public void clickEnter() {
        try {
            clickElement(By.className("seper7ator-link"));
    }catch (NoSuchElementException e){
            e.printStackTrace();

            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build();
        }}

    public void clickRegister() {
            try {
                clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span"));
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
    }

    public void enterFirstName() {
        try {
            By nameLocator = By.xpath("//input[@type='text']");
            WebElement nameWebElement = driver.findElement(nameLocator);
            sendKeys(nameLocator,name);
            String nameGetText = nameWebElement.getText();
            Assert.assertEquals(nameGetText, name);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void enterEmail() {
        try {
            By emailLocator = By.xpath("//input[@type='email']");
            sendKeys(emailLocator, "afhlv26vjfdryyjnjgcyy@gmail.com");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void enterPassword() {
        try {
            By passwordLocator = By.xpath("//input[@type='password']");
            sendKeys(passwordLocator, "Aa12345678");
        }catch (NoSuchElementException e){
       }
    }

    public void re_enterPassword() {
        try {
            By verifyPasswordLocator = (withTagName("input").below(By.xpath("//input[@type='password']")));
            sendKeys(verifyPasswordLocator, ("Aa12345678"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void confirmRegistration() {
        try {
            clickElement(By.className("bm-btn"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

//    public void assertTexts() {
//        WebElement nameWebElement = driver.findElement(nameLocator);
//        assertsText(nameWebElement, "Avi");
//    }
}

