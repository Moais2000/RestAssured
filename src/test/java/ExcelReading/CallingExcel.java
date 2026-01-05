package ExcelReading;

public class CallingExcel {

    public static void main(String[] args) {

        String path = "./Data/testdata.xlsx";
        String sheet_name="Sheet1";

        ReadingCSV obj = new ReadingCSV(path,sheet_name);

        obj.ROW_Count();
        obj.Get_Cell_Data(1,1);
    }
}
