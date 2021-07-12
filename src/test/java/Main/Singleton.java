package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Singleton {
        private static WebDriver driver;

        public static WebDriver getDriverInstance() {
            if(driver == null){
                String type = null;
                try {
                    type = getData("browserType");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(type.equals("Chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\morg\\Downloads\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                }else if(type.equals("FF")){
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\morg\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                    driver = new FirefoxDriver();}
                driver.manage().window().maximize();
            }
            return driver;
        }
        public static String getURL (){
            String type = null;
            try {
                type = getData("URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.get(type);

            return type;
        }

    static String getData(String keyName) throws Exception{
        ClassLoader classLoader = Singleton.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    }

