/*package ajatest;

import java.io.File;


import org.openqa.selenium.WebDriver;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;

public class ReadUserDataExcel {

	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static String ExecutedTestCasesSheet;
	static WritableSheet shSheet;

	public static void readExcel() {
		try {
			wbook = Workbook.getWorkbook(new File(
					"D:/krishna back up/selenium/data driven/aja.xls"));
			wwbCopy = Workbook.createWorkbook(new File(
					"D:/krishna back up/selenium/data driven/ajaCopy.xls"),
					wbook);
			shSheet = wwbCopy.getSheet(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setValueIntoCell(String strSheetName, int iColumnNumber,
			int iRowNumber, String strData) throws WriteException {
		WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
		Label labTemp = new Label(iColumnNumber, iRowNumber, strData);

		try {
			wshTemp.addCell(labTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeFile() {
		try {
			// Closing the writable work book
			wwbCopy.write();
			wwbCopy.close();

			// Closing the original work book
			wbook.close();
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	//
	 // public static void main(String[] args) throws WriteException {
	 //ReadUserDataExcel ds = new ReadUserDataExcel(); //ds.readExcel();
	 // ds.setValueIntoCell("Sheet1", 2, 1, "PASS");
	 // ds.setValueIntoCell("Sheet1", 2, 2, "FAIL");
	 // ds.setValueIntoCell("Sheet1", 2, 3, "PASS"); ds.closeFile(); }
	 //
}*/