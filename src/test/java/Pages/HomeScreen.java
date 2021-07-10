package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();

    public void openAmountList(){
       List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
       for (WebElement element : list);
        list.get(0).click();
    }
    public void chooseAmount(){
        clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/div/ul/li[3]"));
    }
    public void openRegionList (){
        List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
        for (WebElement element : list);
         list.get(1).click();
    }
    public void chooseRegion(){
        clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/div/ul/li[4]"));
    }
    public void openCategoryList (){
        List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
        for (WebElement element : list);
        list.get(2).click();
    }
    public void chooseCategory(){
        clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/div/ul/li[10]"));
    }
    public void pressFindGift(){clickElement(By.cssSelector("a[rel=nofollow"));
    }

}
