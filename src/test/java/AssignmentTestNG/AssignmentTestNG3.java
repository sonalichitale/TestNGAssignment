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
import java.io.FileOutputStream;

public class AssignmentTestNG3 {
    String data = null;
    String value1 = null;

    /*public static void main(String[] args) {
        AssignmentTestNG3 asg=new AssignmentTestNG3();
        asg.modifydata_XL();
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

            for (int i = 0; i < lastRow; i++) {
                Row row = sheet.getRow(i);
                int lastcell = row.getLastCellNum();
                for (int j = 0; j < lastcell; j++) {
                    Cell cell1 = row.getCell(j);
                    // String value1 =cell1.getStringCellValue();
                    System.out.println("Column Value " + cell1);

                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String modifydata_XL(String testcasename1, String columname1) {
        try {

            //String XLFilePath = System.getProperty("user.dir")+"/GETWEB.xlsx";
            String XLFilePath = "C:\\Users\\sonalik\\IdeaProjects\\TESTNG_Assignment\\src\\XLAssignment.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("Worksheet");
            //int lastRow = sheet.getLastRowNum();
            //System.out.println("The last row which has data ==" + lastRow);
            Row row = sheet.getRow(1);
            Cell cell =row.getCell(0);
            cell.setCellValue("Mrunal Chitale");
            FileOutputStream outputStream = new FileOutputStream("/Users/sonalik/IdeaProjects/TESTNG_Assignment/src/XLAssignment.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Test data name Mrunal Chitale modified successfully");

            int lastRow = sheet.getLastRowNum();
            for (int i = 0; i < lastRow; i++) {
                Row row1 = sheet.getRow(i);
                int lastcell = row1.getLastCellNum();
                for (int j = 0; j < lastcell; j++) {
                    Cell cell1 = row1.getCell(j);
                    // String value1 =cell1.getStringCellValue();
                    System.out.println("Column Value " + cell1);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return value1;
    }


    public String Deletedata_XL(String testcasename1, String columname1) {
        try {

            //String XLFilePath = System.getProperty("user.dir")+"/GETWEB.xlsx";
            String XLFilePath = "C:\\Users\\sonalik\\IdeaProjects\\TESTNG_Assignment\\src\\XLAssignment.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("Worksheet");
            //int lastRow = sheet.getLastRowNum();
            //System.out.println("The last row which has data ==" + lastRow);
            Row row = sheet.getRow(1);
            Cell cell =row.getCell(0);
            if (cell != null){
                row.removeCell(cell);
            }
            FileOutputStream outputStream = new FileOutputStream("/Users/sonalik/IdeaProjects/TESTNG_Assignment/src/XLAssignment.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Test data name Mrunal Chitale deleted successfully");

            int lastRow = sheet.getLastRowNum();
            for (int i = 0; i < lastRow; i++) {
                Row row1 = sheet.getRow(i);
                int lastcell = row1.getLastCellNum();
                for (int j = 0; j < lastcell; j++) {
                    Cell cell1 = row1.getCell(j);
                    // String value1 =cell1.getStringCellValue();
                    System.out.println("Column Value " + cell1);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return value1;
    }

    public String updated_XL(String testcasename1, String columname1) {
        try {

            //String XLFilePath = System.getProperty("user.dir")+"/GETWEB.xlsx";
            String XLFilePath = "C:\\Users\\sonalik\\IdeaProjects\\TESTNG_Assignment\\src\\XLAssignment.xlsx";
            FileInputStream myxlfile = new FileInputStream(XLFilePath);
            Workbook workbook = new XSSFWorkbook(myxlfile);
            Sheet sheet = workbook.getSheet("Worksheet");

            int rowindex = 1;
            int cellindex =0;
            Row row = sheet.getRow(rowindex);
            if (row == null){
                row = sheet.createRow(rowindex);
            }

            Cell cell =row.getCell(cellindex);
            if (cell == null) {
                cell = row.createCell(cellindex);
            }
            cell.setCellValue("Sam Sundar");
            FileOutputStream outputStream = new FileOutputStream("/Users/sonalik/IdeaProjects/TESTNG_Assignment/src/XLAssignment.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            System.out.println("Test data name Sam Sundar modified successfully");

            int lastRow = sheet.getLastRowNum();
            for (int i = 0; i < lastRow; i++) {
                Row row1 = sheet.getRow(i);
                int lastcell1 = row1.getLastCellNum();
                for (int j = 0; j < lastcell1; j++) {
                    Cell cell1 = row1.getCell(j);
                    // String value1 =cell1.getStringCellValue();
                    System.out.println("Column Value " + cell1);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return value1;
    }

}