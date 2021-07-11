package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class InformationScreen<wait> extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    private WebDriverWait wait;
    IntroScreen introScreen = new IntroScreen();
    String timeNow = String.valueOf(System.currentTimeMillis());


    public void enterReceiverName(){
        try {
            clickElement(By.xpath("//input[@id='ember1994' and @type='text']"));
            sendKeys(By.xpath("//input[@id='ember1994' and @type='text']"),"מור");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void openForEvent(){
        try {
            clickElement(By.className("selected-text"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void pickEvent(){
        try {
            clickElement(By.xpath("//*[@id=\"ember2102\"]"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void clearBlessingText(){
        try {
            By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
            clickElement(blessingTextLocator);
            driver.findElement((By)blessingTextLocator).clear();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void sendBlessingText(){
        try {
            By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
            sendKeys(blessingTextLocator, "happy birthday!! much love!!");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void uploadPic(){
        try {
            By picLocator = By.xpath("//input[@name='logo' and @type='file']");
            WebElement scrollElement = driver.findElement(picLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(picLocator));
            driver.findElement(picLocator).sendKeys("C:\\Users\\morg\\Desktop\\cutePuppy.jpg");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void pressContinueButton(){
        try {
            clickElement(By.id("ember2011"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }
    public void pressPhone(){
        try {
            clickElement(By.cssSelector("path[class='circle']"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void enterPhone(){
        try {
            clickElement(By.cssSelector("input[type='tel']"));
            sendKeys(By.cssSelector("input[type='tel']"),"0543114709");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void assertSenderName(){
        try {
            WebElement scrollElement = driver.findElement(By.xpath("//input[@id='ember2170' and @maxlength='25']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
            By senderNameLocator = By.xpath("//input[@id='ember2170' and @maxlength='25']");
            clickElement(senderNameLocator);
            WebElement senderNameElement = driver.findElement(senderNameLocator);
            String senderName = "Avi";
            Assert.assertEquals(senderNameElement.getText(), senderName);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void enterSenderPhone(){
        try {
            sendKeys(By.id("ember2179"), "0543223465");
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
}