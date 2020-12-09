package utility;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;

public class ReadExcelSheet
{
    String filePath= System.getProperty("user.dir")+"/src/main/resources/TestData/Data.xlsx";
    XSSFSheet sheet;
    public ReadExcelSheet(String sheetName)
    {
        try
        {
            FileInputStream fileInputStream= new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook= new XSSFWorkbook(fileInputStream);
            sheet= xssfWorkbook.getSheet(sheetName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public HashMap<String, String> GetTestDataFromExcel(int rowNumber)
    {
        //read data row by row and put in map
        HashMap<String, String> hm = new HashMap<>();
        for (int i=0; i<sheet.getRow(0).getLastCellNum();i++)
        {
            String value;
            if(sheet.getRow(rowNumber).getCell(i)!=null)
            {
                sheet.getRow(rowNumber).getCell(i).setCellType(CellType.STRING);
                value= sheet.getRow(rowNumber).getCell(i).toString();
            }
            else
                value= "";
            hm.put(sheet.getRow(0).getCell(i).toString(), value);
        }
        return hm;
    }
}