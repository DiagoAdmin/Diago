package Home;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

//import utility.Log;

public class Home_Login_Link {

	private static WebElement element = null;

	public static WebElement txtbx_UserName(WebDriver driver) {

		element = driver.findElement(By.id("LoginID"));

		return element;

	}

	public static WebElement txtbx_Password(WebDriver driver) {

		element = driver.findElement(By.id("Password"));

		return element;

	}

	public static WebElement btn_LogIn(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@class='register_btn']"));

		return element;

	}

}