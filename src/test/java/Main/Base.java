package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public  class Base {
     private static WebDriver driver = Singleton.getDriverInstance();

     public void clickElement(By locator){
         driver.findElement((By)locator).click();}

    public static void sendKeys(By locator, String text){
        driver.findElement((By)locator).sendKeys(text);
     }
//     public void assertsText(By locator, String text){
//        Assert.assertEquals(driver.findElement(locator).getText(), text);
//     }
}
