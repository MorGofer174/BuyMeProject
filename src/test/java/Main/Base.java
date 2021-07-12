package Main;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;


public  class Base {
    private static WebDriver driver = Singleton.getDriverInstance();
    static String timeNow = String.valueOf(System.currentTimeMillis());


    public void clickElement(By locator) {
        try {
            driver.findElement((By) locator).click();
        } catch (NoSuchElementException e) {
            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build();
        }
    }

    public static void sendKeys(By locator, String text) {
        try {
            driver.findElement((By) locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build();
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

}




