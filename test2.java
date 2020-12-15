import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    static final String DATABASE_URL = test.url;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String USER = test.username;
    static final String PASSWORD = test.password;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        TestMaven testMaven = new TestMaven();
        testMaven.mavenchik();
        Connection connection = null;
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Creating table in selected database...");
            statement = connection.createStatement();

//            String myTableName = "CREATE TABLE AgentDetail ("
//                    + "idNo INT(64) NOT NULL AUTO_INCREMENT,"
//                    + "initials VARCHAR(2),"
//                    + "agentDate DATE,"
//                    + "agentCount INT(64), "
//                    + "PRIMARY KEY(idNo))";


//            String myTableName = "CREATE TABLE carShop ("
//                + "id int auto_increment primary key," +
//                "CarName varchar(30) not null," +
//                "Distance varchar(10) not null," +
//                "Year varchar(10) not null)";


//            statement.executeUpdate(myTableName);
            //statement.executeUpdate("INSERT INTO carShop (CarName, Distance, Year, model) value ('Rotex', 405000, 1908, 'drz')");
            statement.executeUpdate("DELETE FROM carShop where id =2");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop where id =1 ");

            while (resultSet.next()){
                String model = resultSet.getString(2);
                int id=Integer.parseInt(resultSet.getString(1));
                int year = Integer.parseInt(resultSet.getString(4));
                int distance = Integer.parseInt(resultSet.getString(3));
                System.out.println("id = "+ id + "  model = "+model+ " year = "+year+" distance = "+distance);
                System.out.println(resultSet.getString(1)+ " "+
                        resultSet.getString(2)+" "+
                        resultSet.getString(3)+" "+
                        resultSet.getString(4)+" "+
                        resultSet.getString(5));

            }
            System.out.println("Table successfully created...");
        }finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
