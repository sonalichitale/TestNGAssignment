package AssignmentTestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AssignmentTestNG.AssignmentTestNG3;

public class XLsupport {

    String testname = null;

    AssignmentTestNG3 obj;

    @BeforeClass
    public void setup()
    {
        obj =new AssignmentTestNG3();
    }

    @Test
    public void do_all_web_app_test()
    {
        //testname ="Sam Sundar";
        String NameXL =obj.read_And_Print_XL_AsPerTestData(testname,"Name");
        //String YearXL = obj.read_And_Print_XL_AsPerTestData(testname,"Year");
        //YearXL =String.valueOf(YearXL);
        //String DOBXL = obj.read_And_Print_XL_AsPerTestData(testname,"DOB");


    }
}
