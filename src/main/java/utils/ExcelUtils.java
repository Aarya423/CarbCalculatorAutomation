package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    // Updates Actual Results (F=5) and Pass/Fail (G=6)
    public static void updateTestResult(String filePath, String sheetName, String testCaseID, String result, String actualResult) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if(sheet == null) return;

            for (Row row : sheet) {
                Cell idCell = row.getCell(1); // TestCaseID in column B (index 1)
                if (idCell != null && idCell.getStringCellValue().equals(testCaseID)) {
                    row.createCell(5).setCellValue(actualResult); // F → Actual Results
                    row.createCell(6).setCellValue(result);       // G → Pass/Fail
                    break;
                }
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
