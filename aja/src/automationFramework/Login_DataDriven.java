/*package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

//	import pageObjects.*;

import Excel.SetExcelPath;

//	import automationFramework.*;

//import utility.Log;

// Import Package utility.*

import Excel.GetExcelData;
import appModule.Read_Excel;

public class Login_DataDriven {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		// This is to open the Excel file. Excel path, file name and the sheet
		// name are parameters to this method

		GetExcelData.setExcelFile(SetExcelPath.Path_TestData
				+ SetExcelPath.File_TestData, "Sheet1");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(SetExcelPath.URL);

		Read_Excel.Execute(driver);

		System.out
				.println("Login Successfully, now it is the time to Log Off buddy.");

		Thread.sleep(5000);

		// Home_Page.lnk_LogOut(driver).click();
		Logout.windowhandle(driver);
		Thread.sleep(3000);
		driver.quit();

		// This is to send the PASS value to the Excel sheet in the result
		// column.

		// ExcelUtils.setCellData("Pass", 1, 2);

	}

}*/