/*package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import Home.Home_Page;

//import appModule.Read_Excel;

// Import package utility.*

import Excel.SetExcelPath;

public class Param_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the Online Store Website using Constant Variable

		driver.get(SetExcelPath.URL);

		// Pass Constant Variables as arguments to Execute method

		//Read_Excel.Execute(driver);

		System.out
				.println("Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.lnk_LogOut(driver).click();

		driver.quit();

	}

}*/