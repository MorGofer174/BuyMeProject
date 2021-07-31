package Main;

import Extras.Extra;
import Pages.HomeScreen;
import Pages.InformationScreen;
import Pages.IntroScreen;
import Pages.PickBusinessScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Main.Base.takeScreenShot;

public class Main<DB> {

    private static WebDriver driver;
    private static WebDriverWait wait;
    public static Connection conInstance;
    Singleton singleton = new Singleton();
    IntroScreen introScreen = new IntroScreen();
    HomeScreen homeScreen = new HomeScreen();
    PickBusinessScreen pickBusiness = new PickBusinessScreen();
    Extra extra = new Extra();
    InformationScreen informationScreen = new InformationScreen();
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");
    private final String timeNow = String.valueOf(System.currentTimeMillis());

    public Main() throws SQLException {
    }


    @BeforeClass
    public void runOnceBeforeClass() throws SQLException, InterruptedException {  //
        conInstance = singleton.getConnectionInstance();
//        DBMor.createTable(con);
//        DBMor.insertData(con, 1, "URL","https://www.buyme.co.il");
//        DBMor.insertData(con, 2, "BROWSER","Chrome");
//        DBMor.updateDB(con,2);
        DBMor.getTableURL(conInstance);
        driver = singleton.getDriverInstance();
        String URL = singleton.getURL();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extentMor.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");


    }

    @Test (priority = 1)
    public void enter (){
        try {
            introScreen.clickEnter();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }
// Extra Tests

//    @Test (priority = 2)
//    public void enterNoCredentials(){
//        try {
//            extra.pressEnterNoCredentials();
//            test.log(Status.PASS, "executed successfully");
//        } catch (Exception e) {
//            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
//        }
//    }
//
//    @Test(priority = 3)
//    public void assertErrors() {
//        try {
//            extra.assertsErrors();
//            test.log(Status.PASS, "executed successfully");
//        } catch (Exception e) {
//            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
//        }
//    }
    @Test (priority = 4)
    public void registration () {
        try {
            introScreen.clickRegister();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-ember-action='1405']")));
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
        }

    @Test (priority = 5)
    public void firstName(){
        try {
            introScreen.enterFirstName();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
        }

    @Test (priority = 6)
    public void email(){
        try {
            introScreen.enterEmail();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 7)
    public void password(){
        try {
            introScreen.enterPassword();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 8)
    public void passwordAgain(){
        try {
            introScreen.re_enterPassword();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 9)
    public void register() {
        try {
            introScreen.confirmRegistration();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 10)
    public void openAmount(){
        try {
            homeScreen.openAmountList();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 11)
    public void chooseAmount(){
        try {
            homeScreen.chooseAmount();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 12)
    public void openRegion(){
        try {
            homeScreen.openRegionList();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 13)
    public void chooseRegion(){
        try {
            homeScreen.chooseRegion();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 14)
    public void openCategory(){
        try {
            homeScreen.openCategoryList();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }

    }

    @Test (priority = 15)
    public void chooseCategory(){
        try {
            homeScreen.chooseCategory();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 16)
    public void findGift(){
        try {
            homeScreen.pressFindGift();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 17)
    public void assertsPickBusinessURL(){
        try {
            pickBusiness.assertURL();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 18)
    public void picksBusiness(){
        try {
            pickBusiness.pickABusiness();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 19)
    public void picksAmount(){
        try {
            pickBusiness.pickAmount();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 20)
    public void sendReceiverName(){
        try {
            informationScreen.enterReceiverName();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 21)
    public void openEvents(){
        try {
            informationScreen.openForWhatEvent();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 22)
    public void pickEvent(){
        try {
            informationScreen.pickEvent();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 23)
    public void clearsGreetings(){
        try {
            informationScreen.clearBlessingText();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 24)
    public void writGreetings(){
        try {
            informationScreen.sendBlessingText();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 25)
    public void uploadsPic(){
        try {
            informationScreen.uploadPic();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 26)
    public void pressContinue(){
        try {
            informationScreen.pressContinueButton();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 27)
    public void choosePhone(){
        try {
            informationScreen.pressPhone();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 28)
    public void writePhone (){
        try {
            informationScreen.enterPhone();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 29)
    public void assertSendersName (){
        try {
            informationScreen.assertSenderName();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    @Test (priority = 30)
    public void senderPhone(){
        try {
            informationScreen.enterSenderPhone();
            test.log(Status.PASS, "executed successfully");
        } catch (Exception e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }


     @AfterClass //  flushes the report and closes the browser
     public void close() {
        test.log(Status.INFO, "finished");
        extent.flush();
        driver.quit();
    }
    }

//    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(ImagesPath + ".png");
//        try {
//            FileUtils.copyFile(screenShotFile, destinationFile);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return ImagesPath + ".png";

