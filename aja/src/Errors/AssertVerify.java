package Errors;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wait.Waitforpagetoload;
import config.Reading_Properties;

public class AssertVerify {
	
		public static void wait(WebDriver driver) throws InterruptedException
		  {
			Reading_Properties rp=new Reading_Properties();
			try {
				rp.LoadProperties(driver);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
try
{
	String Gs=driver.findElement(By.xpath("/html/body/div[1]/div/h2")).getText();
	if(Gs.contains(rp.getPropertyValue("Inactive_Group")))
	{
		Waitforpagetoload.wait(driver);
		JOptionPane.showMessageDialog(null, "Group is Suspeneded. Please Login with valid credentials", "Group Suspended",
                JOptionPane.INFORMATION_MESSAGE);
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}
}
}
