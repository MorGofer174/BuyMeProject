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

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main<DB> extends Base {

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
 //       DBMor.createLogTable(con);


    }

    @Test (priority = 1)
    public void enter () throws SQLException {
        try {
            introScreen.clickEnter();
            writeTestResult(con,1,timeNow,"pass");
        } catch (Exception e) {
            writeTestResult(con, 1, timeNow, "fail");
        }
    }

    @Test (priority = 2)
    public void registration () throws SQLException {
        try {
            introScreen.clickRegister();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-ember-action='1405']")));
            writeTestResult(con, 2, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 2, timeNow, "fail");
        }
    }

    @Test (priority = 3)
    public void firstName() throws SQLException {
        try {
            introScreen.enterFirstName();
            writeTestResult(con, 3, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 3, timeNow, "fail");
        }
    }

    @Test (priority = 4)
    public void email() throws SQLException {
        try {
            introScreen.enterEmail();
            writeTestResult(con, 4, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 4, timeNow, "fail");
        }
    }

    @Test (priority = 5)
    public void password() throws SQLException {
        try {
            introScreen.enterPassword();
            writeTestResult(con, 5, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 5, timeNow, "fail");
        }
    }

    @Test (priority = 6)
    public void passwordAgain() throws SQLException {
        try {
            introScreen.re_enterPassword();
            writeTestResult(con, 6, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 6, timeNow, "fail");
        }
    }

    @Test (priority = 7)
    public void register() throws SQLException {
        try {
            introScreen.confirmRegistration();
            writeTestResult(con, 7, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 7, timeNow, "fail");
        }
    }

    @Test (priority = 8)
    public void openAmount() throws SQLException {
        try {
            homeScreen.openAmountList();
            writeTestResult(con, 8, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 8, timeNow, "fail");
        }
    }

    @Test (priority = 9)
    public void chooseAmount() throws SQLException {
        try {
            homeScreen.chooseAmount();
            writeTestResult(con, 9, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 9, timeNow, "fail");
        }
    }

    @Test (priority = 10)
    public void openRegion() throws SQLException {
        try {
            homeScreen.openRegionList();
            writeTestResult(con, 10, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 10, timeNow, "fail");
        }
    }

    @Test (priority = 11)
    public void chooseRegion() throws SQLException {
        try {
            homeScreen.chooseRegion();
            writeTestResult(con, 11, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 11, timeNow, "fail");
        }
    }

    @Test (priority = 12)
    public void openCategory() throws SQLException {
        try {
            homeScreen.openCategoryList();
            writeTestResult(con, 12, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 12, timeNow, "fail");
        }
    }

    @Test (priority = 13)
    public void chooseCategory() throws SQLException {
        try {
            homeScreen.chooseCategory();
            writeTestResult(con, 13, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 13, timeNow, "fail");
        }
    }

    @Test (priority = 14)
    public void findGift() throws SQLException {
        try {
            homeScreen.pressFindGift();
            writeTestResult(con, 14, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 14, timeNow, "fail");
        }
    }

    @Test (priority = 15)
    public void assertsPickBusinessURL() throws SQLException {
        try {
            pickBusiness.assertURL();
            writeTestResult(con, 15, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 15, timeNow, "fail");
        }
    }

    @Test (priority = 16)
    public void picksBusiness() throws SQLException {
        try {
            pickBusiness.pickABusiness();
            writeTestResult(con, 16, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 16, timeNow, "fail");
        }
    }

    @Test (priority = 17)
    public void picksAmount() throws SQLException {
        try {
            pickBusiness.pickAmount();
            writeTestResult(con, 17, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 17, timeNow, "fail");
        }
    }

    @Test (priority = 18)
    public void sendReceiverName() throws SQLException {
        try {
            informationScreen.enterReceiverName();
            writeTestResult(con, 18, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 18, timeNow, "fail");
        }
    }

    @Test (priority = 19)
    public void openEvents() throws SQLException {
        try {
            informationScreen.openForWhatEvent();
            writeTestResult(con, 19, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 19, timeNow, "fail");
        }
    }

    @Test (priority = 20)
    public void pickEvent() throws SQLException {
        try {
            informationScreen.pickEvent();
            writeTestResult(con, 20, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 20, timeNow, "fail");
        }
    }

    @Test (priority = 21)
    public void clearsGreetings() throws SQLException {
        try {
            informationScreen.clearBlessingText();
            writeTestResult(con, 21, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 21, timeNow, "fail");
        }
    }

    @Test (priority = 22)
    public void writGreetings() throws SQLException {
        try {
            informationScreen.sendBlessingText();
            writeTestResult(con, 22, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 22, timeNow, "fail");
        }
    }

    @Test (priority = 23)
    public void uploadsPic() throws SQLException {
        try {
            informationScreen.uploadPic();
            writeTestResult(con, 23, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 23, timeNow, "fail");
        }
    }

    @Test (priority = 24)
    public void pressContinue() throws SQLException {
        try {
            informationScreen.pressContinueButton();
            writeTestResult(con, 24, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 24, timeNow, "fail");
        }
    }

    @Test (priority = 25)
    public void choosePhone() throws SQLException {
        try {
            informationScreen.pressPhone();
            writeTestResult(con, 25, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 25, timeNow, "fail");
        }
    }

    @Test (priority = 26)
    public void writePhone () throws SQLException {
        try {
            informationScreen.enterPhone();
            writeTestResult(con, 26, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 26, timeNow, "fail");
        }
    }

    @Test (priority = 27)
    public void assertSendersName () throws SQLException {
        try {
            informationScreen.assertSenderName();
            writeTestResult(con, 27, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 27, timeNow, "fail");
        }
    }

    @Test (priority = 28)
    public void senderPhone() throws SQLException {
        try {
            informationScreen.enterSenderPhone();
            writeTestResult(con, 28, timeNow, "pass");
        } catch (Exception e) {
            writeTestResult(con, 28, timeNow, "fail");
        }
    }


     @AfterClass // closes the browser and the DB connection
     public void close() throws SQLException {
        con.close();
        driver.quit();
    }
    }


