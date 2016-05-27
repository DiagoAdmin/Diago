package ajatest;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import wait.Waitforpagetoload;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ajatest.ReadUserDataExcel;*/
public class UserValidationPopup {
	
	
	public static void windowhandle(WebDriver driver) throws InterruptedException {
		
		try{
			 Waitforpagetoload.wait(driver);
        	Alert alert=driver.switchTo().alert();
        	
        	alert.dismiss();
            
        }
        catch(Exception e)
		{
        	       	
           /* return;*/
           
        }
	}
	
/*public void executeAlert(WebDriver driver) {
	try {
		if (windowhandle(driver)==false) {
			
			
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	/*public void popuphandler(WebDriver driver)
	{
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		                                            // perform operations on popup

		driver.switchTo().window(parentWindowHandler);  // switch back to parent window
	}*/
	
	
}