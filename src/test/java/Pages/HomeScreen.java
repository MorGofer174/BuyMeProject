package Pages;

import Main.Base;
import Main.Singleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class HomeScreen extends Base {

    private static final WebDriver driver = Singleton.getDriverInstance();
    private static final ExtentReports extent= new ExtentReports();
    private static final ExtentTest test = extent.createTest("BuyMeSanity", "MyFirstLog");
    private final String timeNow = String.valueOf(System.currentTimeMillis());

    public void openAmountList(){      // clicks on the first combo box choose amount
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list);
            list.get(0).click();
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    public void chooseAmount(){    // chooses one of the options
            clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/div/ul/li[3]"));
    }

    public void openRegionList (){    // clicks on the second combo box choose region
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list);
            list.get(1).click();
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }
    public void chooseRegion(){         // chooses one of the options
            clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/div/ul/li[4]"));
    }

    public void openCategoryList () {     // clicks on the third combo box choose category
        try {
            List<WebElement> list = driver.findElements(By.className("chosen-container-single"));
            for (WebElement element : list) ;
            list.get(2).click();
            test.pass("executed successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        } catch (NoSuchElementException e) {
            test.fail("execution failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, timeNow)).build());
        }
    }

    public void chooseCategory(){      // chooses one of the options
            clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/div/ul/li[10]"));
    }

    public void pressFindGift(){       //clicks on find gift
            clickElement(By.cssSelector("a[rel=nofollow"));
    }

}
