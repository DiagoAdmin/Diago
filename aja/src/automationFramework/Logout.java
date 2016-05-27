/*package automationFramework;

import Home.*;
import Excel.GetExcelData;

import java.io.FileOutputStream;
 import java.util.concurrent.TimeUnit;

 import jxl.Workbook;
 import jxl.write.Label;
 import jxl.write.WritableSheet;
 import jxl.write.WritableWorkbook;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Logout {
	// private static WebElement element = null;
	// WebDriver driver = new FirefoxDriver();
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	public static void windowhandle(WebDriver driver) throws Exception {

		String popuphandle = driver.getWindowHandle();
		WebDriver popup = driver.switchTo().window(popuphandle);
		String checklogin = popup.getTitle();
		// writereport(checklogin);
		if (checklogin.equals("Login Failed")) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			for (int row = 1; row <= 14; row++) {

				driver.findElement(
						By.xpath("/html/body/div[5]/div[3]/div/button"))
						.click();
				GetExcelData.setCellData("Fail", row, 2);
			}
		} else {
			for (int row = 1; row <= 14; row++) {

				driver.findElement(
						By.xpath("/html/body/div[5]/div[3]/div/button"))
						.click();
				GetExcelData.setCellData("Pass", row, 2);
				// driver.findElement(By.className("loginn_btn")).click();
				Home_Page.lnk_LogOut(driver).click();
			}
		}
	}
	
	 * public void writereport(String text) { try { FileOutputStream fo = new
	 * FileOutputStream
	 * ("D:/krishna back up/selenium/data driven/output.xls",true);
	 * WritableWorkbook book = Workbook.createWorkbook(fo); WritableSheet sheet
	 * = book.createSheet("output", 0); Label l = new Label(0, 0, text);
	 * sheet.addCell(l); book.write(); book.close(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 
}*/