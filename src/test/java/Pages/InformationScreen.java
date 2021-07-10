package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InformationScreen<wait> extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    private WebDriverWait wait;


    public void enterReceiverName(){
        clickElement(By.xpath("//input[@id='ember1994' and @type='text']"));
        sendKeys(By.xpath("//input[@id='ember1994' and @type='text']"),"מור");
    }
    public void openForEvent(){
        clickElement(By.className("selected-text"));
    }
    public void pickEvent(){
        clickElement(By.xpath("//*[@id=\"ember2102\"]"));
    }
    public void clearBlessingText(){
        By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
        clickElement(blessingTextLocator);
        driver.findElement((By)blessingTextLocator).clear();
    }
    public void sendBlessingText(){
        By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
        sendKeys(blessingTextLocator, "happy birthday!! much love!!");
    }
    public void uploadPic(){
        By picLocator = By.xpath("//input[@name='logo' and @type='file']");
        WebElement scrollElement = driver.findElement(picLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(picLocator));
        driver.findElement(picLocator).sendKeys("C:\\Users\\morg\\Desktop\\cutePuppy.jpg");
    }
    public void pressContinueButton(){
        clickElement(By.id("ember2011"));
    }
    public void pressPhone(){
        clickElement(By.cssSelector("path[class='circle']"));
    }
    public void enterPhone(){
        clickElement(By.cssSelector("input[type='tel']"));
        sendKeys(By.cssSelector("input[type='tel']"),"0543114709");
    }
    public void assertSenderName(){
        WebElement scrollElement = driver.findElement(By.xpath("//input[@id='ember2170' and @maxlength='25']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
        By senderNameLocator = By.xpath("//input[@id='ember2170' and @maxlength='25']");
        clickElement(senderNameLocator);
        WebElement senderNameElement = driver.findElement(senderNameLocator);
        String senderName = "AVI";
        Assert.assertEquals(senderName, senderNameElement.getText());
    }
    public void enterSenderPhone(){
        sendKeys(By.id("ember2179"), "0543223465");
    }
}