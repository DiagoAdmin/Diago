/*package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

// Import package pageObject.*

import Home.Home_Page;

import Home.Home_Login_Link;

// import utility.Log;

public class PageObjectModel {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");

		// Use page Object library now

		Home_Page.lnk_MyAccount(driver).click();

		Home_Login_Link.txtbx_UserName(driver).sendKeys("testuser_1");

		Home_Login_Link.txtbx_Password(driver).sendKeys("Test@123");

		Home_Login_Link.btn_LogIn(driver).click();

		System.out
				.println(" Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.lnk_LogOut(driver).click();

		driver.quit();

	}

}*/