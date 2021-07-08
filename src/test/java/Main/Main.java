package Main;

import Pages.IntroScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;
    private static WebDriverWait wait;
    IntroScreen introScreen = new IntroScreen();

    @BeforeClass
    public void runOnceBeforeClass() {  // opens chrome browser with URL
        driver = Singleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test (priority = 1)
    public void enter (){
        introScreen.clickEnter();
    }

    @Test (priority = 2)
    public void registration (){
        introScreen.clickRegister();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")));
    }
    @Test (priority = 3)
    public void firstName(){
        introScreen.enterFirstName();
    }
    @Test (priority = 4)
    public void email(){
        introScreen.enterEmail();
    }
    @Test (priority = 5)
    public void password(){
        introScreen.enterPassword();
    }
    @Test (priority = 6)
    public void passwordAgain(){
        introScreen.re_enterPassword();
    }
    @Test (priority = 7)
    public void register(){
        introScreen.confirmRegistration();
    }
    @Test (priority = 8)
    public void assertion(){
        introScreen.assertsTexts();
    }



     @AfterClass // closes the browser
      public void close() {
      //  driver.quit();
    }
}
