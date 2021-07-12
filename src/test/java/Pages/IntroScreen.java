package Pages;

import Main.Base;
import Main.Singleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static final WebDriver driver = Singleton.getDriverInstance();
    private static final ExtentReports extent = Base.getReportInstance();
    public static ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");
    String timeNow = String.valueOf(System.currentTimeMillis());
//    static ExtentReports thisExtent = Main.extent;
//    private static ExtentTest test = thisExtent.createTest("BuyMeSanity", "MyFirstLog");
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
            test.log(Status.PASS, "executed successfully");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    public void enterEmail() {        // sends email and asserts
        By emailLocator = By.xpath("//input[@type='email']");
        sendKeys(emailLocator, "afh6l77dhjnyttjj5jjhkkjj5jkkj8j3njgcyy@gmail.com");
        WebElement emailWebElement = driver.findElement(emailLocator);
        assertsText(emailWebElement, "afh6l77dhjnyttjj5jjhkkjj5jkkj8j3njgcyy@gmail.com");
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

