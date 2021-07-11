package Main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;


public  class Base {
     private static WebDriver driver = Singleton.getDriverInstance();

     public void clickElement(By locator){
         driver.findElement((By)locator).click();}

    public static void sendKeys(By locator, String text){
        driver.findElement((By)locator).sendKeys(text);
     }

    public void assertsText(WebElement element, String text){
         element.click();
        Assert.assertEquals(element.getText(), text);
     }

    public static void takeElementScreenShot(WebElement element){
        File screenShotFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot-png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
 }

