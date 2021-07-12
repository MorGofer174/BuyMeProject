package Pages;

import Main.Base;
import Main.Singleton;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static final WebDriver driver = Singleton.getDriverInstance();
    String timeNow = String.valueOf(System.currentTimeMillis());
    public static String name = "Avi";


    public void clickEnter() {            // clicks on user enter
        clickElement(By.className("seperator-link"));
    }

    public void clickRegister() {         // clicks on registration
        clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span"));
    }

    public void enterFirstName() {        // sends first name and asserts
        try {
            By nameLocator = By.xpath("//input[@type='text']");
            WebElement nameWebElement = driver.findElement(nameLocator);
            nameWebElement.sendKeys(name);
            assertsText(nameWebElement, name);
        } catch (NoSuchElementException e) {
            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build();
        }
    }

    public void enterEmail() {        // sends email and asserts
        By emailLocator = By.xpath("//input[@type='email']");
        sendKeys(emailLocator, "afbbb8j3njgcy88@gmail.com");
        WebElement emailWebElement = driver.findElement(emailLocator);
        assertsText(emailWebElement, "afbbb8j3njgcy88@gmail.com");
    }

    public void enterPassword() {     // sends password and asserts
        By passwordLocator = By.xpath("//input[@type='password']");
        sendKeys(passwordLocator, "Aa12345678");
        WebElement passwordWebElement = driver.findElement(passwordLocator);
        assertsText(passwordWebElement, "Aa12345678");
    }

    public void re_enterPassword() {     // sends password again and asserts
        By verifyPasswordLocator = (withTagName("input").below(By.xpath("//input[@type='password']")));
        sendKeys(verifyPasswordLocator, ("Aa12345678"));
        WebElement verifyPasswordWebElement = driver.findElement(verifyPasswordLocator);
        assertsText(verifyPasswordWebElement, "Aa12345678");
    }

    public void confirmRegistration() {   // clicks on registration
        clickElement(By.className("bm-btn"));
    }
}

