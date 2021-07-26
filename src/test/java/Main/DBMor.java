package Main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DB {
//    private static final String USER_NAME = "sql6427759";
//    private static final String DATABASE_NAME = "sql6427759";
//    private static final String PASSWORD = "QHSDxAB9LF";
//    private static final String PORT = "3306";
//    private static final String SERVER = "sql6.freemysqlhosting.net";
//    Connection con;
//
//    private static void DBcon () throws SQLException {
//    Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);
//}
//
//    public void createTable() throws SQLException {
//        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`users`(`id` INT NOT NULL,`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));";
//        con.createStatement().execute(statementToExecute);
//    }
//
//}

import java.sql.*;

public class DBMor {
    private static final String USER_NAME = "sql6427759";
    private static final String DATABASE_NAME = "sql6427759";
    private static final String PASSWORD = "QHSDxAB9LF";
    private static final String PORT = "3306";
    private static final String SERVER = "sql6.freemysqlhosting.net";

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT, USER_NAME, PASSWORD);

        createTable(con);
//        insertUser(con, 123, "daniel");
//        getTableContent(con);
//        deleteUserByName(con, "daniel");
//        updateUserName(con,1234, "John");
        con.close();
    }

    public static void createTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`users`(`id` INT NOT NULL,`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));";
        con.createStatement().execute(statementToExecute);
    }
}