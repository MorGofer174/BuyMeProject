package Main;

import Extras.Extra;
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
    Extra extra = new Extra();
    InformationScreen informationScreen = new InformationScreen();
    public static ExtentReports extent= new ExtentReports();
    public static ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");

    @BeforeClass
    public void runOnceBeforeClass() {  // opens chrome browser with URL
        driver = Singleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
    }
    @Test (priority = 1)
    public void enter (){
        try {
            introScreen.clickEnter();
            test.log(Status.PASS,"executed successfully");
        }catch (Exception e){
        test.log(Status.FAIL,"execution failed");}
    }

    @Test (priority = 2)
    public void enterNoCredentials(){
        try {
            extra.pressEnterNoCredentials();
            test.log(Status.PASS,"executed successfully");
        }catch (Exception e){
            test.log(Status.FAIL,"execution failed");}
    }

    @Test(priority = 3)
    public void assertErrors(){
        try {
            extra.assertsErrors();
            test.log(Status.PASS,"executed successfully");
        }catch (Exception e){
            test.log(Status.FAIL,"execution failed");}
    }

    @Test (priority = 4)
    public void registration () {
        try {
            introScreen.clickRegister();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember882\"]/div/div[1]/div/div/div[3]/div[1]/span")));
        test.log(Status.PASS,"executed successfully");
        }catch (Exception e){
        test.log(Status.FAIL,"execution failed");}
        }

    @Test (priority = 5)
    public void firstName(){
        try {
            introScreen.enterFirstName();
            test.log(Status.PASS,"executed successfully");
        }catch (Exception e){
        test.log(Status.FAIL,"execution failed");}
        }

    @Test (priority = 6)
    public void email(){
        introScreen.enterEmail();
    }

    @Test (priority = 7)
    public void password(){
        introScreen.enterPassword();
    }

    @Test (priority = 8)
    public void passwordAgain(){
        introScreen.re_enterPassword();
    }

    @Test (priority = 9)
    public void register(){
        introScreen.confirmRegistration();
    }

    @Test (priority = 10)
    public void openAmount(){ homeScreen.openAmountList();}

    @Test (priority = 11)
    public void chooseAmount(){ homeScreen.chooseAmount();}

    @Test (priority = 12)
    public void openRegion(){homeScreen.openRegionList();}

    @Test (priority = 13)
    public void chooseRegion(){ homeScreen.chooseRegion();}

    @Test (priority = 14)
    public void openCategory(){homeScreen.openCategoryList();}

    @Test (priority = 15)
    public void chooseCategory(){ homeScreen.chooseCategory();}

    @Test (priority = 16)
    public void findGift(){ homeScreen.pressFindGift();}

    @Test (priority = 17)
    public void assertsPickBusinessURL(){ pickBusiness.assertURL();}

    @Test (priority = 18)
    public void picksBusiness(){ pickBusiness.pickABusiness();}

    @Test (priority = 19)
    public void picksAmount(){pickBusiness.pickAmount();}

    @Test (priority = 20)
    public void sendReceiverName(){informationScreen.enterReceiverName();}

    @Test (priority = 21)
    public void openEvents(){informationScreen.openForWhatEvent();}

    @Test (priority = 22)
    public void pickEvent(){informationScreen.pickEvent();}

    @Test (priority = 23)
    public void clearsGreetings(){informationScreen.clearBlessingText();}

    @Test (priority = 24)
    public void writGreetings(){informationScreen.sendBlessingText();}

    @Test (priority = 25)
    public void uploadsPic(){informationScreen.uploadPic();}

    @Test (priority = 26)
    public void pressContinue(){informationScreen.pressContinueButton();}

    @Test (priority = 27)
    public void choosePhone(){informationScreen.pressPhone();}

    @Test (priority = 28)
    public void writePhone (){informationScreen.enterPhone();}

    @Test (priority = 29)
    public void assertSendersName (){informationScreen.assertSenderName();}

    @Test (priority = 30)
    public void senderPhone(){informationScreen.enterSenderPhone();}


     @AfterClass //  flushes the report and closes the browser
     public void close() {
        test.log(Status.INFO, "finished");
        extent.flush();
        driver.quit();
    }
}
