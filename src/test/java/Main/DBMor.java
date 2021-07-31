package Main;

import java.sql.*;

public class DBMor {
    private static String USER_NAME;
    private static final String DATABASE_NAME = "sql6427759";
    private static String PASSWORD;
    private static String PORT;
    private static String SERVER;
    public static String config_URL_data;
    public static String config_Browser_data;

    public DBMor() throws SQLException {
    }

    // creating config table to store the URL + Browser
    public static void createConfigTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`config`(`config_id` INT NOT NULL,`config_name` VARCHAR(45) NOT NULL,`config_data` VARCHAR(45) NOT NULL, PRIMARY KEY (`config_id`));";
        con.createStatement().execute(statementToExecute);
    }
    // inserting the URL + Browser to the DB
    public static void insertData(Connection con, int config_id, String config_name, String config_data) throws SQLException {
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".config (`config_id`, `config_name`, `config_data`) VALUES ('" + config_id + "', '" + config_name + "','" + config_data + "');";
        con.createStatement().execute(statementToExecute);
    }
    // creating history table to store the test results
    public static void createLogTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`history`(`test_id` INT NOT NULL,`test_date` VARCHAR(50) NOT NULL,`test_result` VARCHAR(10) NOT NULL, PRIMARY KEY (`test_id`));";
        con.createStatement().execute(statementToExecute);
    }
    // writing the test results
    public static void writeToLog (Connection con, int test_id, String test_date, String test_result) throws SQLException {
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".history (`test_id`, `test_date`, `test_result`) VALUES ('" + test_id + "', '" + test_date + "','" + test_result + "');";
        con.createStatement().execute(statementToExecute);
    }
    // clearing log - in case we need to run the tests again
    public static void clearLog(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "TRUNCATE my_table";
        stmt.executeUpdate(sql);
        }
    // getting the browser from DB
    public static void getTableBrowser(Connection con) throws SQLException {
        String statementToExecute = "SELECT `config_data` FROM " + DATABASE_NAME + ".config WHERE `config_id` = '2';";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            config_Browser_data = rs.getString("config_data");
        }
        rs.close();
    }
    // getting the URL from DB
    public static void getTableURL(Connection con) throws SQLException {
        String statementToExecute = "SELECT `config_data` FROM " + DATABASE_NAME + ".config WHERE `config_id` = '1';";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            config_URL_data = rs.getString("config_data");
            System.out.println(config_URL_data);
        }
        rs.close();
    }

    //updates one of the table rows - needed that to correct a typo, if needed again.
    public static void updateDB (Connection con) throws SQLException {
        String statementToExecute = "UPDATE `" + DATABASE_NAME + "`.`config` SET `config_data`='Chrome' WHERE `config_id`='2';";
        con.createStatement().executeUpdate(statementToExecute);

    }
}