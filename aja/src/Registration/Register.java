package Registration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import wait.Waitforpagetoload;
import config.Reading_Properties;

public class Register {
	
	public void RegisterTest(WebDriver driver) throws IOException, InterruptedException
	{
		Reading_Properties rp=new Reading_Properties();
		rp.LoadProperties(driver);
	      
	      driver.get(rp.getPropertyValue("ajahomepageurl"));
	      
	      driver.manage().window().maximize();
	      driver.findElement(By.xpath(rp.getPropertyValue("registration"))).click();
	      
		/*String currenturl=driver.getCurrentUrl();
		if(currenturl==rp.getPropertyValue("ajaregistration"))
		{*/
			WebElement gradid=driver.findElement(By.id("GraduationYr"));
			
			Select s=new Select(gradid);
			s.selectByVisibleText("2015");
			
			WebElement countryid=driver.findElement(By.id("ddl_countryID"));
			
			Select s1=new Select(countryid);
			s1.selectByVisibleText("Canada");
			
		
	}
	

}
