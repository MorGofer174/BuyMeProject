package Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;


public  class Base {
    private static WebDriver driver = Singleton.getDriverInstance();
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;
    static String timeNow = String.valueOf(System.currentTimeMillis());


    public void clickElement(By locator) {
        try {
            driver.findElement((By) locator).click();
            test.log(Status.PASS, "executed successfully");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    public static void sendKeys(By locator, String text) {
        try {
            driver.findElement((By) locator).sendKeys(text);
            test.log(Status.PASS, "executed successfully");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    public void assertsText(WebElement element, String text) {
        String value = element.getAttribute("value");
        Assert.assertEquals(value, text);
    }


    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    public static ExtentReports getReportInstance() {{
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("MyFirstTest", "Sample description");}
     return extent;}
}
//        if(driver == null){
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\morg\\Downloads\\chromedriver_win32\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//        return driver;



