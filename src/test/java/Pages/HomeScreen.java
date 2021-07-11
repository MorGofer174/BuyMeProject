package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class HomeScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();
    String timeNow = String.valueOf(System.currentTimeMillis());

    public void openAmountList(){
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list);
            list.get(0).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void chooseAmount(){
        try {
            clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/div/ul/li[3]"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void openRegionList (){
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list);
            list.get(1).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void chooseRegion(){
        try {
            clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/div/ul/li[4]"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void openCategoryList (){
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list);
            list.get(2).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void chooseCategory(){
        try {
            clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/div/ul/li[10]"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void pressFindGift(){
        try {
            clickElement(By.cssSelector("a[rel=nofollow"));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

}
