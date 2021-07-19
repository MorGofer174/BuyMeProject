package Main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;


public  class Base {
    public static WebDriver driver = Singleton.getDriverInstance();
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");
    private final String timeNow = String.valueOf(System.currentTimeMillis());


    public void clickElement(By locator) {     // general method to click on element
        try {
            driver.findElement(locator).click();
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    public void sendKeys(By locator, String text) {    // general method that sends keys to element
        try {
            driver.findElement(locator).sendKeys(text);
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    public void assertsText(WebElement element, String text) {  // asserts text
        String value = element.getAttribute("value");
        try{
            Assert.assertEquals(value, text);
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }


    public static String takeScreenShot(WebDriver driver, String ImagesPath) {
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




