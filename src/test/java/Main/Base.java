package Main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;


public  class Base {
    public static WebDriver driver = Singleton.getDriverInstance();


    public void clickElement(By locator) {     // general method to click on element
            driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {    // general method that sends keys to element
            driver.findElement(locator).sendKeys(text);
    }

    public void assertsText(WebElement element, String text) {  // asserts text
        String value = element.getAttribute("value");
            Assert.assertEquals(value, text);
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




