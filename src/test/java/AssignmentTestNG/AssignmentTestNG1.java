package AssignmentTestNG;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class AssignmentTestNG1 {



    @BeforeClass
    public void setup()
    {

    }

    @Parameters({"url"})
    @Test
    public void Create_dummy_json(String url)
    {
        Response response =get(url);
        String res = response.getBody().asString();
        int status_code= response.statusCode();
        System.out.println("Status code is "+status_code);
        String title = response.getBody().jsonPath().getString("title");
        System.out.println("Title is "+title);
        String price = response.getBody().jsonPath().getString("price");
        System.out.println("Price is "+price);
        String brand = response.getBody().jsonPath().getString("brand");
        System.out.println("Brand is "+brand);
        int image_count = response.getBody().jsonPath().getList("images").size();
        System.out.println("Image count is "+image_count);
        for (int a =0;a<image_count;a++)
        {
            String images1 = response.getBody().jsonPath().getString("images["+a+"]");
            System.out.println("Image .jpg is "+images1);
        }
    }

    @AfterClass
    public void teardown()
    {

    }
}
