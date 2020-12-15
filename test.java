import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class test {
    public static final String username = "root";
    public static final String password = "180288";
    public static final String url = "jdbc:mysql://localhost:3306/dur?serverTimezone=Europe/Moscow&useSSL=false";
    public static Connection connection;
    public static Statement statement;

    static {
        //String url = "jdbc:mysql://localhost:3306/dur?serverTimezone=Europe/Moscow&useSSL=false";
        //String username = "root";
        //String password = "180288";
        //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection to Store DB succesfull!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");

        }
    }
//    static {
////        try{
//////            statement = connection.createStatement();
////        }catch (SQLException trouble) {
////            trouble.printStackTrace();
////        }
////    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE developers " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(50), " +
                " specialty VARCHAR (50), " +
                " salary INTEGER not NULL, " +
                " PRIMARY KEY (id))");
//        "CREATE TABLE 'test' ("
//                + "id int auto_increment primary key," +
//                "name varchar(30) not null," +
//                "name1 varchar(10) not null," +
//                "name2 varchar(10) not null)");

    }
}
