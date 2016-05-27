/*package ajatest;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUserData {
	public static void userlogindata(WebDriver driver) throws Exception {
		Sheet s;
		FileInputStream fi = new FileInputStream(
				"D:/krishna back up/selenium/data driven/aja.xls");
		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		for (int row = 1; row <= s.getRows(); row++) {
			if (row <= 100) {
				String username = s.getCell(0, row).getContents();
				System.out.println("username is " + username);
				driver.get("http://10.200.0.63");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				//Assert.assertTrue(driver.getTitle().equals("ACR Journal Advisor"));
				driver.findElement(By.className("loginn_btn")).click();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.findElement(By.id("LoginID")).sendKeys();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				String password = s.getCell(1, row).getContents();
				Thread.sleep(3000);
				System.out.println("password is " + password);
				driver.findElement(By.id("Password")).sendKeys(password);
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@class='register_btn']")).click();
			}
		}
	}
}*/