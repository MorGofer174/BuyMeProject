package Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;


public  class Base {
    private static final WebDriver driver = Singleton.getDriverInstance();
    private String timeNow = String.valueOf(System.currentTimeMillis());
    public static ExtentReports extent= new ExtentReports();
    public static ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");


    public void clickElement(By locator) {     // general method to click on element
        try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        } // i tried the screenshots with thr log and it didn't work, i don't know how to make it work!! :(
    }

    public void sendKeys(By locator, String text) {    // general method that sends keys to element
        try {
            driver.findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }  // also tried it without the log, still didn't work
    }

    public void assertsText(WebElement element, String text) {  // asserts text
        String value = element.getAttribute("value");
        Assert.assertEquals(value, text);
    }


//    public static String takeScreenShot(String ImagesPath) {    // the screenshot method you gave us
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("\"C:\\Users\\morg\\Desktop\\buyme screenshots\\" + timeNow + ".png");
//        try {
//            FileUtils.copyFile(screenShotFile, destinationFile);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return ImagesPath + ".png";
//    }
    static String takeScreenShot(WebDriver driver, String ImagesPath) {
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




