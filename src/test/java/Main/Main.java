package Main;

import Pages.HomeScreen;
import Pages.InformationScreen;
import Pages.IntroScreen;
import Pages.PickBusinessScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
    HomeScreen homeScreen = new HomeScreen();
    PickBusinessScreen pickBusiness = new PickBusinessScreen();
    InformationScreen informationScreen = new InformationScreen();
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public void runOnceBeforeClass() {  // opens chrome browser with URL
        driver = Singleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html"); //todo
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
    }
    @Test (priority = 1)
    public void enter (){
        introScreen.clickEnter();
    }

    @Test (priority = 2)
    public void registration (){
        introScreen.clickRegister();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")));}

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
       // introScreen.assertTexts();
    }

    @Test (priority = 9)
    public void openAmount(){ homeScreen.openAmountList();}

    @Test (priority = 10)
    public void chooseAmount(){ homeScreen.chooseAmount();}

    @Test (priority = 11)
    public void openRegion(){homeScreen.openRegionList();}

    @Test (priority = 12)
    public void chooseRegion(){ homeScreen.chooseRegion();}

    @Test (priority = 13)
    public void openCategory(){homeScreen.openCategoryList();}

    @Test (priority = 14)
    public void chooseCategory(){ homeScreen.chooseCategory();}

    @Test (priority = 15)
    public void findGift(){ homeScreen.pressFindGift();}

    @Test (priority = 16)
    public void assertsPickBusinessURL(){ pickBusiness.assertURL();}

    @Test (priority = 17)
    public void picksBusiness(){ pickBusiness.pickABusiness();}

    @Test (priority = 18)
    public void picksAmount(){pickBusiness.pickAmount();}

    @Test (priority = 19)
    public void sendReceiverName(){informationScreen.enterReceiverName();}

    @Test (priority = 20)
    public void openEvents(){informationScreen.openForEvent();}

    @Test (priority = 21)
    public void pickEvent(){informationScreen.pickEvent();}

    @Test (priority = 22)
    public void clearsGreetings(){informationScreen.clearBlessingText();}

    @Test (priority = 23)
    public void writGreetings(){informationScreen.sendBlessingText();}

    @Test (priority = 24)
    public void uploadsPic(){informationScreen.uploadPic();}

    @Test (priority = 25)
    public void pressContinue(){informationScreen.pressContinueButton();}

    @Test (priority = 26)
    public void choosePhone(){informationScreen.pressPhone();}

    @Test (priority = 27)
    public void writePhone (){
        informationScreen.enterPhone();
    }
    @Test (priority = 28)
    public void assertSendersName (){
        informationScreen.assertSenderName();
    }
    @Test (priority = 29)
    public void senderPhone(){
    informationScreen.enterSenderPhone();
    }


     @AfterClass // closes the browser
      public void close() {
         extent.flush();
      //  driver.quit();
    }
}
