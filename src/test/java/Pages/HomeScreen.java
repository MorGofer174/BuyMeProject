package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();

    List<WebElement> list;
    //= driver.findElements(By.className("chosen-container-single"));

    public void openAmountList(){
        List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
        for (WebElement element : list){
            if (element.getText().contains("100")); {
                element.click();
            }
        }
    }
    public void chooseAmount(){
        clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/div/ul/li[3]"));
    }
    public void openRegionList (){
        clickElement(By.id("ember993_chosen"));
        //  clickElement(By.className("chosen-container-single-nosearch"));
    }
}
