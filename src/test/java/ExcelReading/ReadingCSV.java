package ExcelReading;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingCSV {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ReadingCSV(String filepath,String sheetname){

        try {
            workbook = new XSSFWorkbook(filepath);

            sheet = workbook.getSheet(sheetname);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void ROW_Count(){
        int rows_count = sheet.getPhysicalNumberOfRows();
        System.out.println("Row Count: " + rows_count);
        }

    public static void Get_Cell_Data(int row_num,int col_num){
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(row_num).getCell(col_num));
        System.out.println("Cell Value: " + value);
    }


    }

