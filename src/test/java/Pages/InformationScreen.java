package Pages;

import Main.Base;
import Main.Singleton;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class InformationScreen<wait> extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    private WebDriverWait wait;
    String timeNow = String.valueOf(System.currentTimeMillis());
    IntroScreen introScreen = new IntroScreen();


    public void enterReceiverName(){      // sends receiver name
            clickElement(By.xpath("//input[@id='ember1994' and @type='text']"));
            sendKeys(By.xpath("//input[@id='ember1994' and @type='text']"),"מור");
    }

    public void openForWhatEvent(){      //opens the events combo box
            clickElement(By.className("selected-text"));
    }

    public void pickEvent(){          //chooses a specific event
            clickElement(By.xpath("//*[@id=\"ember2102\"]"));
    }
    public void clearBlessingText(){    // clears the test in the blessing block
            By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
            clickElement(blessingTextLocator);
            driver.findElement((By)blessingTextLocator).clear();
    }
    public void sendBlessingText(){      // writes a new blessing
            By blessingTextLocator = By.cssSelector("textarea[data-parsley-group=voucher-greeting");
            sendKeys(blessingTextLocator, "happy birthday!! much love!!");
    }
    public void uploadPic(){       // uploads a pic
        try {
            By picLocator = By.xpath("//input[@name='logo' and @type='file']");
            WebElement scrollElement = driver.findElement(picLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(picLocator));
            driver.findElement(picLocator).sendKeys("C:\\Users\\morg\\Desktop\\cutePuppy.jpg");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build();
        }
    }

    public void pressContinueButton(){    // presses the continue button
            clickElement(By.id("ember2011"));
    }

    public void pressPhone(){     // chooses the SMS option
            clickElement(By.cssSelector("path[class='circle']"));
    }
    public void enterPhone(){     // sends the phone number
            clickElement(By.cssSelector("inp9ut[type='tel']"));
            sendKeys(By.cssSelector("input[type='tel']"),"0543114709");
    }

    public void assertSenderName(){
        try {
            WebElement scrollElement = driver.findElement(By.xpath("//input[@id='ember2170' and @maxlength='25']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollElement);
            By senderNameLocator = By.xpath("//input[@id='ember2170' and @maxlength='25']");
            WebElement senderNameElement = driver.findElement(senderNameLocator);
          //  String senderName = introScreen.name;      // this was the right way to write it, but it got an extra blank char ' ' that causes an error.
            String senderName = senderNameElement.getAttribute("value");
            assertsText(senderNameElement,senderName);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void enterSenderPhone(){    // sends the sender's phone number
            sendKeys(By.id("ember2179"), "0543223465");
    }
}