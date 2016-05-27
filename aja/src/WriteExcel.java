import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
public class WriteExcel {
	private static HSSFSheet ExcelWSheet;
  //define an Excel Work Book
  HSSFWorkbook workbook;
  //define an Excel Work sheet
  HSSFSheet sheet;
  //define a test result data object
  Map<String, Object[]> testresultdata;
  WebDriver driver;
  public void CreateResult(ITestContext context){
	     
	     //create a new work book
	      workbook = new HSSFWorkbook();
	      //create a new work sheet
	       sheet = workbook.createSheet("Test Result");
	      
	      testresultdata = new LinkedHashMap<String, Object[]>();
	     
	      //add test result excel file column header
	      //write the header in the first row
	      testresultdata.put("1", new Object[] {"Test Step Id", "SQL Result", "Application Result","Outcome"});
	    
	  }
  public void Result(String sql,String appl) throws InterruptedException{
	  ExcelWSheet = workbook.getSheet("Sheet1");
	 
	    try{
	    	 for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
	    	 {
	      //add pass entry to the excel sheet
	      testresultdata.put("i", new Object[] {1d,sql,appl,"Pass"});
	    	 }
	    }
	    catch(Exception e)
	    {
	      //add fail entry to the excel sheet
	    	for(int i=1;i<=ExcelWSheet.getLastRowNum();i++)
	    	 {
	      //add pass entry to the excel sheet
	      testresultdata.put("i", new Object[] {1d,sql,appl,"Fail"});
	    	 }
	    }
	  }

  public void WriteResult() {
    //write excel file and file name is TestResult.xls 
    Set<String> keyset = testresultdata.keySet();
    int rownum = 0;
    for (String key : keyset) {
        Row row = sheet.createRow(rownum++);
        Object [] objArr = testresultdata.get(key);
        int cellnum = 0;
        for (Object obj : objArr) {
            Cell cell = row.createCell(cellnum++);
            if(obj instanceof Date) 
                cell.setCellValue((Date)obj);
            else if(obj instanceof Boolean)
                cell.setCellValue((Boolean)obj);
            else if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Double)
                cell.setCellValue((Double)obj);
        }
    }
    try {
        FileOutputStream out =new FileOutputStream(new File("TestResult.xls"));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");
         
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}