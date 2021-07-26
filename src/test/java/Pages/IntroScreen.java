package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    public static WebDriver driver = Singleton.getDriverInstance();
    public static String name = "Avi";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void clickEnter() {            // clicks on user enter
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("seperator-link")));
        clickElement(By.className("seperator-link"));
    }

    public void clickRegister() {         // clicks on registration
        clickElement(By.cssSelector("span[data-ember-action='1405']"));
    }

    public void enterFirstName() {        // sends first name and asserts
        By nameLocator = By.xpath("//input[@type='text']");
        WebElement nameWebElement = driver.findElement(nameLocator);
        nameWebElement.sendKeys(name);
        assertsText(nameWebElement, name);
    }

    public void enterEmail() {        // sends email and asserts
        By emailLocator = By.xpath("//input[@type='email']");
        clickElement(By.xpath("//input[@type='email']"));
        sendKeys(emailLocator, "jlkjnkkhhkuhylkml888@gmail.com");
        WebElement emailWebElement = driver.findElement(emailLocator);
        assertsText(emailWebElement, "jlkjnkkhhkuhylkml888@gmail.com");
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

