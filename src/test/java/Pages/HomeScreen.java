package Pages;

import Main.Base;
import Main.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen extends Base {

    private static WebDriver driver = Singleton.getDriverInstance();

    public void amountButton (){
        clickElement(By.className("chosen-container-single"));
    }
    public void chooseAmount(){
        clickElement(By.partialLinkText("100-199"));
    }

}
