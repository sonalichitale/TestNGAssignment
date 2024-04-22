package AssignmentTestNG;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class AssignmentTestNG3 {
    String data = null;

   /* public static void main(String[] args) {
        AssignmentTestNG3 asg=new AssignmentTestNG3();
        asg.read_And_Print_XL_AsPerTestData();
    }*/

    public String read_And_Print_XL_AsPerTestData(String testcasename, String columname) {

        //String data = null;
        try {

            //String XLFilePath = System.getProperty("user.dir")+"/GETWEB.xlsx";
            String XLFilePath = "C:\\Users\\sonalik\\IdeaProjects\\TESTNG_Assignment\\src\\XLAssignment.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("Worksheet");
            int lastRow = sheet.getLastRowNum();
            System.out.println("The last row which has data ==" + lastRow);


            for (int i=0;i<lastRow;i++)
            {
                Row row =sheet.getRow(i);
                int lastcell =row.getLastCellNum();
                for (int j=0;j<lastcell;j++) {
                    Cell cell1 =row.getCell(j);
                   // String value1 =cell1.getStringCellValue();
                    System.out.println("Column Value "+cell1);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}