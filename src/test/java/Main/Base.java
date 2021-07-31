package Main;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public  class Base {
    public static Connection con;
    File ByuMeFile = new File("C:\\BuyMe2TestResults.txt");
    public static FileWriter fileWriter;
    private static String testResult;

    static {
        try {
            fileWriter = new FileWriter("C:\\BuyMe2TestResults.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveResultsToFile(String testResult) { // saves the results to txt file
        try {
            File ByuMeFile = new File("C:\\BuyMe2TestResults.txt");
            if (ByuMeFile.createNewFile()) {
                System.out.println("File created: " + ByuMeFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("C:\\BuyMe2TestResults.txt", true);
            writer.write("\n" + testResult);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    static {
        try {
            con = Singleton.getConnectionInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static WebDriver driver = Singleton.getDriverInstance();


    public void clickElement(By locator) {     // general method to click on element
            driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {    // general method that sends keys to element
            driver.findElement(locator).sendKeys(text);
    }

    public void assertsText(WebElement element, String text) {  // asserts text
        String value = element.getAttribute("value");
            Assert.assertEquals(value, text);
    }

    public void writeTestResult(Connection con, int test_id, String test_date, String test_result) throws SQLException { // saves the test results in DB table, if there is no connection - writes to txt file
        if (con != null && !con.isClosed()){
            DBMor.writeToLog(con,test_id,test_date,test_result);}
        else {
            testResult = ""+ test_id+"+"+test_date+"+"+test_result+"";
            saveResultsToFile(testResult);
        }
        }
 //   }

// from last project - not used in this one
    public static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }

}




