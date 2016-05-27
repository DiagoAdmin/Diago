/*package Excel;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Test_Reports_Excel 
{
   public static void main(String[] args) throws Exception 
   {
      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
      //Create row object
      XSSFRow row;
      //This data needs to be written (Object[])
      Map < String, Object[] > empinfo = 
      new TreeMap < String, Object[] >();
      empinfo.put( "1", new Object[] { 
      "EMP ID", "EMP NAME", "DESIGNATION" });
      empinfo.put( "2", new Object[] { 
      "tp01", "Gopal", "Technical Manager" });
      empinfo.put( "3", new Object[] { 
      "tp02", "Manisha", "Proof Reader" });
      empinfo.put( "4", new Object[] { 
      "tp03", "Masthan", "Technical Writer" });
      empinfo.put( "5", new Object[] { 
      "tp04", "Satish", "Technical Writer" });
      empinfo.put( "6", new Object[] { 
      "tp05", "Krishna", "Technical Writer" });
      //Iterate over data and write to sheet
      Set < String > keyid = empinfo.keySet();
      int rowid = 0;
      for (String key : keyid)
      {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = empinfo.get(key);
         int cellid = 0;
         for (Object obj : objectArr)
         {
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream( 
      new File("Writesheet.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("Writesheet.xlsx written successfully");
   }
}*/
package Excel;
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
public class Test_Reports_Excel {
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
	  ExcelWSheet = workbook.getSheet("Test Result");
	 
	    try{
	    	 for(int i=1;i<=ExcelWSheet.getPhysicalNumberOfRows();i++)
	    	 {
	      //add pass entry to the excel sheet
	      testresultdata.put("i", new Object[] {1d,sql,appl,"Pass"});
	    	 }
	    }
	    catch(Exception e)
	    {
	      //add fail entry to the excel sheet
	    	for(int i=1;i<=ExcelWSheet.getPhysicalNumberOfRows();i++)
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