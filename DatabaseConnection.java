package com.example.fxnew;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/*public class DatabaseConnection {
    public static void main(String[] args) throws SQLException {
        public Connection getConnection()

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/paytrack", "root", "hello");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT Username,Password FROM customer WHERE customerID = '101'");
            while (resultSet.next()) {
                String idli = resultSet.getString("Username");
                System.out.print(idli);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
*/
public class DatabaseConnection{
    public Connection databaseLink;

    public Connection getConnection(){

        /*try{
            Class.forName("com.mysql://localhost:3306/paytrack");
            databaseLink = DriverManager.getConnection("jdbc:mysql://localhost:3306/paytrack", "root", "hello");
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }*/
            try {
                databaseLink = DriverManager.getConnection("jdbc:mysql://localhost:3306/paytrack", "root", "hello");
                //Statement statement = connection.createStatement();
                //ResultSet resultSet = statement.executeQuery("SELECT Username,Password FROM customer WHERE customerID = '101'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return databaseLink;
        }
}
