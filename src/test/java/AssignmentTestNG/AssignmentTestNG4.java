package AssignmentTestNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AssignmentTestNG4 {

    Connection connection;

   public static void main(String[] args) {
        AssignmentTestNG4 dbconnect = new AssignmentTestNG4();
        dbconnect.select_table();
    }

    public void createdatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "sonali", "maveric@123");
            if (connection != null) {
                System.out.println("Database server is connected");
            }

            Statement statement = connection.createStatement();
            statement.execute("Create Database companies");
            System.out.println("Database created successfully");

        } catch (Exception e) {
            System.out.println("SQL Error");
        }
    }

    public void CreateNewTable() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "sonali", "maveric@123");
            if (connection != null) {
                System.out.println("database server is connected");
            }
            Statement statement = connection.createStatement();
            statement.execute("company table company");
            statement.execute("create table company \n" +
                    " (id varchar (20),\n" +
                    " name varchar (20),\n" +
                    " address varchar (50),\n" +
                    " zip varchar (10)\n" +
                    " country varchar (20),\n" +
                    " employeeCount varchar (50),\n" +
                    " industry varchar (10)\n" +
                    " marketCap varchar (10)\n" +
                    " domain varchar (20),\n" +
                    " logo varchar (50),\n" +
                    " ceo varchar (10)\n" +
                    " )");
            System.out.println("Database table is created");
        } catch (Exception e) {

        }
    }

    public void select_table() {
        try {
            //url,username and dbpassword
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "sonali", "maveric@123");
            if (connection != null) {
                System.out.println("database server is connected");
            }

            Statement statement = connection.createStatement();
            statement.execute("use comapny");
            ResultSet resultSet = statement.executeQuery("select id,name,address,zip,country,employeeCount,industry,marketCap,domain,logo,ceoName from company");
            System.out.println("select data");

        }
        //handle exception
        catch (Exception e) {
            System.out.println("SQL error");
        }
    }
}
