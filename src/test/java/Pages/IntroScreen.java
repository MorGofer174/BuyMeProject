package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    public static String name = "Avi";
    public static WebElement element;


    public void clickEnter() {
        try {
            clickElement(By.className("seperator-link"));
    }catch (InvalidElementStateException e){
            e.printStackTrace();
            takeElementScreenShot((WebElement) By.className("seperator-link"));
        }}

    public void clickRegister() {
            try {
                clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span"));
            }catch (InvalidElementStateException e){
                e.printStackTrace();
                takeElementScreenShot((WebElement) By.className("seperator-link"));
            }
    }

    public void enterFirstName() {
        By nameLocator = By.xpath("//input[@type='text']");
        WebElement nameWebElement = driver.findElement(nameLocator);
        sendKeys(nameLocator,name);
        String nameGetText = nameWebElement.getText();
        Assert.assertEquals(nameGetText, name);
    }

    public void enterEmail() {
        try {
            By emailLocator = By.xpath("//input[@type='email']");
            sendKeys(emailLocator, "afhlv26vjnjgcyy@gmail.com");
        }catch (InvalidElementStateException e){
            e.printStackTrace();
            takeElementScreenShot((WebElement) By.className("seperator-link"));
        }
    }

    public void enterPassword() {
        try {
            By passwordLocator = By.xpath("//input[@type='password']");
            sendKeys(passwordLocator, "Aa12345678");
        }catch (InvalidElementStateException e){
            e.printStackTrace();
            takeElementScreenShot((WebElement) By.className("seperator-link"));
        }
    }

    public void re_enterPassword() {
        try {
            By verifyPasswordLocator = (withTagName("input").below(By.xpath("//input[@type='password']")));
            sendKeys(verifyPasswordLocator, ("Aa12345678"));
        }catch (InvalidElementStateException e){
            e.printStackTrace();
            takeElementScreenShot((WebElement) By.className("seperator-link"));
        }
    }

    public void confirmRegistration() {
        try {
            clickElement(By.className("bm-btn"));
        }catch (InvalidElementStateException e){
            e.printStackTrace();
            takeElementScreenShot((WebElement) By.className("seperator-link"));
        }
    }

//    public void assertTexts() {
//        WebElement nameWebElement = driver.findElement(nameLocator);
//        assertsText(nameWebElement, "Avi");
//    }
}

