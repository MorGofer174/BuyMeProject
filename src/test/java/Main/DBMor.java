package Main;

import java.sql.*;

public class DBMor {
   // Connection con = Singleton.getConnectionInstance();
    private static String USER_NAME;
    private static String DATABASE_NAME = "sql6427759";
    private static String PASSWORD;
    private static String PORT;
    private static String SERVER;
    public static String config_URL_data;
    public static String config_Browser_data;

    public DBMor() throws SQLException {
    }


    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);

    //    createTable(con);
   //     insertUser(con, 1, "URL","https://www.buyme.co.il");
//        getTableBrowser(con);
//        deleteUserByName(con, "daniel");
//        updateUserName(con,1234, "John");
        con.close();
    }

    public static void createTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`config`(`config_id` INT NOT NULL,`config_name` VARCHAR(45) NOT NULL,`config_data` VARCHAR(45) NOT NULL, PRIMARY KEY (`config_id`));";
        con.createStatement().execute(statementToExecute);
    }
    public static void insertData(Connection con, int config_id, String config_name, String config_data) throws SQLException {
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".config (`config_id`, `config_name`, `config_data`) VALUES ('" + config_id + "', '" + config_name + "','" + config_data + "');";
        con.createStatement().execute(statementToExecute);
    }

    public static void getTableBrowser(Connection con) throws SQLException {
        String statementToExecute = "SELECT `config_data` FROM " + DATABASE_NAME + ".config WHERE `config_id` = '2';";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            config_Browser_data = rs.getString("config_data");
            System.out.println(config_Browser_data);
        }
        rs.close();
    }

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
}