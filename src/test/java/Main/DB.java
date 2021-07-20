package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String USER_NAME = "sql6425258";
    private static final String DATABASE_NAME = "sql6425258";
    private static final String PASSWORD = "XN61ZTsYc5";
    private static final String PORT = "3306";
    private static final String SERVER = "sql6.freemysqlhosting.net";

    private static void DBcon () throws SQLException {
    Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);
}

    public static void createTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`users`(`id` INT NOT NULL,`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));";
        con.createStatement().execute(statementToExecute);
    }


}
