package AssignmentTestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import java.sql.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class AssignmentTestNG4 {

    Connection connection;

   public static void main(String[] args) {
        AssignmentTestNG4 dbconnect = new AssignmentTestNG4();
        //dbconnect.createdatabase();
            dbconnect.CreateNewTable("https://fake-json-api.mock.beeceptor.com/companies");
            dbconnect.update_data(3,"India","Mumbai 123");
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

    public void CreateNewTable(String url) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "sonali", "maveric@123");
            if (connection != null) {
                System.out.println("database server is connected");
            }
            Statement statement = connection.createStatement();
            statement.execute("use companies");
            statement.execute("create table companydata23 \n" +
                    " (id int,\n" +
                    " name varchar (255),\n" +
                    " address varchar (255),\n" +
                    " zip varchar (255),\n" +
                    " country varchar (255),\n" +
                    " employeeCount varchar (255),\n" +
                    " industry varchar (255),\n" +
                    " marketCap varchar (255),\n" +
                    " domain varchar (255),\n" +
                    " logo varchar (255),\n" +
                    " ceo varchar (255)\n" +
                    " )");
            System.out.println("Database table is created");

            Response response =get(url);
            String res = response.getBody().asString();
            System.out.println(res);
            int idcount = response.getBody().jsonPath().getList("id").size();
            System.out.println(idcount);
            for (int i=0;i<idcount;i++) {
                String id = response.getBody().jsonPath().getString("id[" + i + "]");
                System.out.println(id);
                   String name = response.getBody().jsonPath().getString("name["+id+"]");
                System.out.println(name);
                 String address = response.getBody().jsonPath().getString("address["+id+"]");
                System.out.println(address);
                    String zip = response.getBody().jsonPath().getString("zip["+id+"]");
                System.out.println(zip);
                    String country = response.getBody().jsonPath().getString("country["+id+"]");
                System.out.println(country);
                    String employeeCount = response.getBody().jsonPath().getString("employeeCount["+id+"]");
                System.out.println(employeeCount);
                    String industry = response.getBody().jsonPath().getString("industry["+id+"]");
                System.out.println(industry);
                    String marketCap = response.getBody().jsonPath().getString("marketCap["+id+"]");
                System.out.println(marketCap);
                    String domain= response.getBody().jsonPath().getString("domain["+id+"]");
                System.out.println(domain);
                    String logo = response.getBody().jsonPath().getString("logo["+id+"]");
                System.out.println(logo);
                    String ceoName = response.getBody().jsonPath().getString("ceoName["+id+"]");
                System.out.println(ceoName);

                //insert data from get call
                String query = "insert into companydata23 values ("+id+",\""+name+"\",\""+address+"\","+zip+",\""+country+"\","+employeeCount+",\""+industry+"\","+marketCap+",\""+domain+"\",\""+logo+"\",\""+ceoName+"\")";
                System.out.println("Table data is inserted");

            }


        } catch (Exception e) {
            System.out.println("SQL error");

        }
    }

    public void update_data(int id,String new_country,String new_address) {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "sonali", "maveric@123");
            Statement statement = connection.createStatement();

            //update data
                String update_datequery = "update companies.companydata23 set country= \""+new_country+"\" ,address= \""+new_address+"\" where id= "+id+"";
                statement.executeUpdate(update_datequery);
                System.out.println("Update query executed successfully");
        }
        //handle exception
        catch (Exception e) {
            System.out.println("SQL error");
        }
    }
}
