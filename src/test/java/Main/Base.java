package Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html"); //todo
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");



    public void clickElement(By locator) {
        try {
            driver.findElement((By) locator).click();
        } catch (NoSuchElementException e){
            test.info("details".MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("pic")).build());
        }
    }

    public static void sendKeys(By locator, String text){
        try {
            driver.findElement((By)locator).sendKeys(text);
        } catch (NoSuchElementException e){
            test.info("details".MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("pic")).build());
        }
     }

    public void assertsText(WebElement element, String text){
         element.click();
        Assert.assertEquals(element.getText(), text);
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
 }

