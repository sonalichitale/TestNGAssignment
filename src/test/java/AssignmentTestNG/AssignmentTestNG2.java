package AssignmentTestNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import AssignmentTestNG.PostJsonAssig2;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.get;

public class AssignmentTestNG2 {

    PostJsonAssig2 RJB;
    String user_id;
    String response_body;

    @BeforeClass
    public void Setup()
    {
        RJB = new PostJsonAssig2();
    }
    @Parameters({"url","name1","year1","DOB1","Address1","Salary1"})
    @Test(priority = 0)
    public void Create_Post_API(String url,String name1,String year1,String DOB1,String Address1,String Salary1)
    {
        Response res = given().
                contentType(ContentType.JSON).
                body(RJB.CreatePostJson(name1,year1,DOB1,Address1,Salary1)).
                when().
                post(url);
        int status_code =res.statusCode();
        response_body =res.getBody().asString();
        System.out.println(status_code);
        System.out.println(response_body);
        user_id = res.getBody().jsonPath().getString("id");
        System.out.println("ID is "+user_id);
         // getcall(user_id);

    }

    //@Test
   /*public void getcall(String user_id)
    {
       //String url= "https://api.restful-api.dev//objects?id=";
        Response response =get("https://api.restful-api.dev//objects?id="+user_id);
        String data1 = response.getBody().asString();
        //String Url1 =user_id;
      //  String complete_url = response+ Url1;
        System.out.println(data1);
    }*/
    @Parameters({"url","name1","year1","DOB1","Address1","Salary1"})
    @Test(priority = 1)
    public void getcall(String url,String name1,String year1,String DOB1,String Address1,String Salary1)
    {
        Response response =get(url+"?id="+user_id);
        String data1 = response.getBody().asString();
        System.out.println(data1);
        int status_code = response.statusCode();
        System.out.println(status_code);
        String year = response.getBody().jsonPath().getString("data[0].year");
        System.out.println("Year is "+year);
        Assert.assertEquals(year,year1);
        String name = response.getBody().jsonPath().getString("name[0]");
        //String actualValue = name.replaceAll("[\\[\\]]", "");
        System.out.println("Name is "+name);
        Assert.assertEquals(name,name1);
        String DOB = response.getBody().jsonPath().getString("data[0].DOB");
        System.out.println("Year is "+DOB);
        Assert.assertEquals(DOB,DOB1);
        String Address = response.getBody().jsonPath().getString("data[0].Address");
        System.out.println("Address is "+Address);
        Assert.assertEquals(Address,Address1);
        String Salary = response.getBody().jsonPath().getString("data[0].Salary");
        System.out.println("Salary is "+Salary);
        Assert.assertEquals(Salary,Salary1);

    }

    @Parameters({"url","name1","year1","DOB1","UpdatedAddress","Salary1"})
    @Test(priority = 2)
    public void put_call(String url,String name1,String year1,String DOB1,String UpdatedAddress,String Salary1 )
    {
        Response res = given().
                contentType(ContentType.JSON).
                body(RJB.CreatePostJson(name1,year1,DOB1,UpdatedAddress,Salary1)).
                when().
                put(url+"/"+user_id);
        String response_body =res.getBody().asString();
        int status_code =res.getStatusCode();
        Assert.assertEquals(status_code,200);
        System.out.println(status_code);
        String Address = res.getBody().jsonPath().getString("data.Address");
        System.out.println("UpdatedAddress in Put call is "+Address);
        Assert.assertEquals(Address,UpdatedAddress);

        //again get call
        Response response =get(url+"?id="+user_id);
        String response_body1 =res.getBody().asString();
        int Newstatus_code1 =res.getStatusCode();
        Assert.assertEquals(Newstatus_code1,200);
        String updatedAddress1 = res.getBody().jsonPath().getString("data.Address");
        System.out.println("UpdatedAddress in Get call is "+updatedAddress1);
        Assert.assertEquals(updatedAddress1,UpdatedAddress);
    }


    @Parameters({"url","name1","year1","DOB1","UpdatedAddress","Salary1"})
    @Test(priority = 3)
    public void delete_call(String url,String name1,String year1,String DOB1,String UpdatedAddress,String Salary1 ) {
        Response res = given().
                contentType(ContentType.JSON).
                body(RJB.CreatePostJson(name1, year1, DOB1, UpdatedAddress, Salary1)).
                when().
                delete(url + "/" + user_id);
        String response_body = res.getBody().asString();
        int status_code = res.getStatusCode();
        Assert.assertEquals(status_code, 200);
        System.out.println("Object with id ="+user_id+" has been deleted");

        //again get call
        Response response_delete =get(url+"?id="+user_id);
        String response_body1 =res.getBody().asString();
        int Newstatus_code1 =res.getStatusCode();
        Assert.assertEquals(Newstatus_code1,200);
        System.out.println("Won't be having any data previous test data deleted ");
    }


    @AfterClass
    public void Demoend()
    {

    }
}
