package Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class Singleton {
        private static WebDriver driver;

        public static WebDriver getDriverInstance(){
            if(driver == null){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\morg\\Downloads\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            return driver;
        }
    }

