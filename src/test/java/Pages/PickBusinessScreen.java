package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PickBusinessScreen extends Base {

    public static WebDriver driver = Singleton.getDriverInstance();

    public void assertURL(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://buyme.co.il/search?budget=2&category=315&region=9", URL);
    }
    public void pickABusiness(){   //chooses a specific business
            clickElement(By.cssSelector("img[data-lazy='https://buyme.co.il/files/siteNewLogo389018.jpg?1490022860162'"));
    }
    public void pickAmount (){     // chooses a specific amount / package.
            clickElement(By.className("bm-gift-card-link"));
    }
}
