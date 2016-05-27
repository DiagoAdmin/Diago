/*package appModule;

import org.openqa.selenium.WebDriver;

import Home.Home_Page;

import Home.Home_Login_Link;

import Excel.GetExcelData;
// import utility.Log;

// Now this method does not need any arguments

public class Read_Excel {

	public static void Execute(WebDriver driver) throws Exception {

		// This is to get the values from Excel sheet, passing parameters (Row
		// num &amp; Col num)to getCellData method
		for (int row = 1; row <= 14; row++) {

			String sUserName = GetExcelData.getCellData(row, 0);

			String sPassword = GetExcelData.getCellData(row, 1);

			Home_Page.lnk_MyAccount(driver).click();

			Home_Login_Link.txtbx_UserName(driver).sendKeys(sUserName);

			Home_Login_Link.txtbx_Password(driver).sendKeys(sPassword);

			Home_Login_Link.btn_LogIn(driver).click();

		}

	}
}// }
*/