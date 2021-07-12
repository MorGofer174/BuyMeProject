package Extras;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Extra extends Base {

    private static final WebDriver driver = Singleton.getDriverInstance();

    public void pressEnterNoCredentials(){
        clickElement(By.cssSelector("button[type='submit'"));
    }

    public void assertsErrors(){
        WebElement errorWebElement = driver.findElement(By.cssSelector("ul[id='parsley-id-14'"));
        String errorText = errorWebElement.getText();
        Assert.assertEquals(errorText, "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");
    }

}
