package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
        private static WebDriver driver;
        private static String USER_NAME;
        private static String DATABASE_NAME;
        private static String PASSWORD;
        private static String PORT;
        private static String SERVER;
        private static Connection con;
        static DBMor dbMor;

    static {
        try {
            dbMor = new DBMor();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnectionInstance() {
        if(con == null){
            String USER_NAME = "sql6427759";
            String DATABASE_NAME = "sql6427759";
            String PASSWORD = "QHSDxAB9LF";
            String PORT = "3306";
            String SERVER = "sql6.freemysqlhosting.net";
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return con;
    }

    public static WebDriver getDriverInstance(){
        if(driver == null){
            String browserType = null;
            try {
                if (con != null && !con.isClosed()) {
                    try{
                    browserType = dbMor.config_Browser_data;
                } catch (Exception e) {
                e.printStackTrace();
            }
                } else {
                    try{
                    browserType = getData("browserType");
                } catch (Exception e) {
                    e.printStackTrace();
                }}
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(browserType.equals("Chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\morg\\Downloads\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                   }else if(browserType.equals("FF")){
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\morg\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
                    driver = new FirefoxDriver();}
                    driver.manage().window().maximize();
            }
            return driver;
    }


    public static String getURL () throws SQLException {
        String urlType = null;
        if (con != null && !con.isClosed()) {
            try {
                urlType = dbMor.config_URL_data;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                urlType = getData("URL");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.get(urlType);
        return urlType;
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

