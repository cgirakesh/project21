package orange.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utlites1 {

    static String projectpath = System.getProperty("user.dir");
    static String excelpath = projectpath + "\\src\\test\\resources\\Orangehrm_Testdata\\dynamicdata.xlsx";

    // Only sheetname is needed, because file path is already fixed above
    public static Object[][] getdata(String sheetname) throws IOException {
        FileInputStream fs = new FileInputStream(new File(excelpath));
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheet(sheetname);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        int colcount = worksheet.getRow(0).getLastCellNum();

        System.out.println("Rows: " + rowcount + " | Cols: " + colcount);

        Object[][] data = new Object[rowcount - 1][colcount]; 

        for (int i = 1; i < rowcount; i++) {  
            for (int j = 0; j < colcount; j++) {
                data[i - 1][j] = worksheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        fs.close();

        return data;
    }
}