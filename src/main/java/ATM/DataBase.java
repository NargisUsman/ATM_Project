package ATM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataBase {

    //private final static String path = "/Users/ray/Documents/git/ATM_Project/src/main/DataBase/ClientDataBase.xlsx";
    private final static String path = "./src/main/DataBase/ClientDataBase.xlsx";

    public static String readExcelFile(int row, int column) {

        String value = "";
        try {
            File src = new File(path);
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh1 = wb.getSheetAt(0);
            Cell cell = sh1.getRow(row).getCell(column);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            value = cell.getStringCellValue();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int lengthOfList() {

        int length = 0;
        try {
            File src = new File(path);
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh1 = wb.getSheetAt(0);
            length = sh1.getLastRowNum();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return length;
    }

    public static void writeExcelFile(String strVal, int row, int column) {

        try {
            File src = new File(path);                                 // Creating a File object to declare the path
            FileInputStream fis = new FileInputStream(src);            // Read the spreadsheet that needs to be updated
            XSSFWorkbook wb = new XSSFWorkbook(fis);                   // Access the workbook
            XSSFSheet sh1 = wb.getSheetAt(0);                    // Access the worksheet, so that we can update/modify it.
            Cell cell = sh1.getRow(row).getCell(column);               // Declare a Cell object and access the given cell and given row to update the value
            cell.setCellValue(strVal);                                 // Get current cell value value and overwrite the value
            fis.close();                                                // Close the InputStream

            FileOutputStream output_file = new FileOutputStream(src);  // Open FileOutputStream to write updates using the same path
            wb.write(output_file);                                     // Write changes
            output_file.close();                                       // Close the OutputStream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
