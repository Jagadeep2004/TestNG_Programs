package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class utilsExcel {

    String path = "D:\\TestNG_Programs\\DataDrivenTestingDemo\\src\\test\\resources\\Book1.xlsx";

    @DataProvider(name = "validData")
    public Object[][] validData() throws IOException {

        Object[][] arrObj = getExcelData(path, "Sheet1");

        return new Object[][]{
                arrObj[0]
        };
    }

    @DataProvider(name = "invalidData", parallel = true)
    public Object[][] invalidData() throws IOException {

        Object[][] arrObj = getExcelData(path, "Sheet1");

        return new Object[][]{
                arrObj[1],
                arrObj[2]
        };
    }
    
    
//    @DataProvider(name = "validData")
//    public Object[][] validData() throws IOException {
//
//        return getExcelData(path, "Sheet1");
//    }
//    
//    @DataProvider(name = "invalidData")
//    public Object[][] invalidData() throws IOException {
//
//        return getExcelData(path, "Sheet2");
//    }
    

    public String[][] getExcelData(String filename, String sheetname) throws IOException {

        String[][] data = null;

        FileInputStream fis = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet(sheetname);

        XSSFRow row = sheet.getRow(0);

        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();

        Cell cell;

        data = new String[noOfRows - 1][noOfCols];

        for (int i = 1; i < noOfRows; i++) {

            row = sheet.getRow(i);

            for (int j = 0; j < noOfCols; j++) {

                cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}