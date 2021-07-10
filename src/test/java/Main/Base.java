package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public  class Base {
     private static WebDriver driver = Singleton.getDriverInstance();

     public void clickElement(By locator){
         driver.findElement((By)locator).click();}

    public static void sendKeys(By locator, String text){
        driver.findElement((By)locator).sendKeys(text);
     }
     public void assertsText(WebElement element, String text){
        Assert.assertEquals(element.getText(), text);
     }
}
