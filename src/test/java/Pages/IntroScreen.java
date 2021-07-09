package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class IntroScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();


    public void clickEnter() {
        clickElement(By.className("seperator-link"));}

    public void clickRegister() {
        clickElement(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span"));}

    public void enterFirstName () {
        sendKeys(By.xpath("//input[@type='text']"),"AVI");
    }

    public void enterEmail () {
        sendKeys(By.xpath("//input[@type='email']"),"av1300865i@gmail.com");
    }

    public void enterPassword () {
        sendKeys(By.xpath("//input[@type='password']"),"Aa12345678");
    }

    public void re_enterPassword () {
        sendKeys((withTagName("input").below(By.xpath("//input[@type='password']"))),("Aa12345678"));
    }

    public void confirmRegistration(){
        clickElement(By.className("bm-btn"));
    }
    public void assertsTexts (){


    }
}

