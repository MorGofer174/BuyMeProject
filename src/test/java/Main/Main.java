package Main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    private static WebDriver driver;

    @BeforeClass
    public void runOnceBeforeClass() {  // opens chrome browser with URL
        driver = Singleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
    }
    @Test
    public void stam (){
        System.out.println("fa");
    }



    @AfterClass // closes the browser
    public void close() {
        driver.quit();
    }
}
