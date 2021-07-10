package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();

    private static By nameLocator  = By.xpath("//input[@type='text']");



    public void clickEnter() {clickElement(By.className("seperator-link"));}

    public void clickRegister() {clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span"));}

    public void enterFirstName () {
        By nameLocator = By.xpath("//input[@type='text']");
        sendKeys(nameLocator,"AVI");}

    public void enterEmail () {
        By emailLocator = By.xpath("//input[@type='email']");
        sendKeys(emailLocator,"annj9uhy@gmail.com");}

    public void enterPassword () {
        By passwordLocator = By.xpath("//input[@type='password']");
        sendKeys(passwordLocator,"Aa12345678");}

    public void re_enterPassword () {
        By verifyPasswordLocator =(withTagName("input").below(By.xpath("//input[@type='password']")));
        sendKeys(verifyPasswordLocator,("Aa12345678"));}

    public void confirmRegistration(){clickElement(By.className("bm-btn"));}

    public void assertTexts (){
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")));
       // assertsText(nameLocator, "avi");
      //  assertsText(emailLocator, "avitrf56465345hy@gmail.com");
//        assertsText(passwordLocator, "Aa12345678");
//        assertsText(verifyPasswordLocator, "Aa12345678");



    }
}

