/*package excelDataStorage;
import java.io.File;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;
import ajatest.ReadUserDataExcel;
public class ExcelInterface implements ReadUserDataExcel {
	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static String
	}
 ExecutedTestCasesSheet;
 static WritableSheet shSheet;
 @Override 
 public void readExcel()
 { 
	 try
	 { 
		 wbook = Workbook.getWorkbook(new File("D:/krishna back up/selenium/data driven/aja.xls"));
		 wwbCopy = Workbook.createWorkbook(new File("D:/krishna back up/selenium/data driven/ajaCopy.xls"), wbook);
		 shSheet= wwbCopy.getSheet(0);
		 } 
	 catch(Exception e) 
	 {
		 e.printStackTrace();
		 }
	 }
 public void setValueIntoCell(String strSheetName,int iColumnNumber, int iRowNumber,String strData) throws WriteException
 { 
	 WritableSheet wshTemp = wwbCopy.getSheet(strSheetName); 
 Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
 try
 { 
	 wshTemp.addCell(labTemp); 
	 }
 catch (Exception e) 
 {
	 e.printStackTrace();
 } 
 }
 public void closeFile()
 { try
 { // Closing the writable work book
 wwbCopy.write(); 
 wwbCopy.close();
 // Closing the original work book
 wbook.close();
 } catch (Exception e)
 {
	 e.printStackTrace();
	 }
 }
 }
 */