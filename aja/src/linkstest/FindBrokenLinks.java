/*package linkstest;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.Waitforpagetoload;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class FindBrokenLinks {
 public static void linktest(WebDriver driver) throws InterruptedException {
	 //public static void main(String[]args) throws InterruptedException {
  //WebDriver driver = new FirefoxDriver();
  //driver.get("10.200.0.63/");
  //Waitforpagetoload.wait(driver);
  //int size = driver.findElements(By.tagName("a")).size();
  //System.out.println(size);
  List<String> Linkarray = new ArrayList<String>();
     
      List<WebElement> Linklist = driver.findElements(By.tagName("a"));
     
      for (WebElement link : Linklist) {
        
       String links = link.getText();
       Linkarray.add(links);
       
      }
      for (String linkToTest : Linkarray){
    	 		
   // 	driver.findElement(By.linkText(linkToTest)).click();
    	 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
    	 driver.findElement(By.linkText(linkToTest)).sendKeys(selectLinkOpeninNewTab);
    	 Waitforpagetoload.wait(driver);
    	 if (driver.getTitle().contains("Server Error")) {
    		 driver.quit();
    	 }
    	 else
    	 {
    		 Waitforpagetoload.wait(driver);
    	 } 
      }
 }
}*/
package linkstest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import wait.Waitforpagetoload;
public class FindBrokenLinks {
    public static int invalidLink;
    String currentLink;
    String temp;
    public static void linktest(WebDriver driver) throws InterruptedException {
        List<WebElement> ele = driver.findElements(By.tagName("a"));
       // System.out.println("size:" + ele.size());
        boolean isValid = true;
        for (int i = 0; i < ele.size(); i++) {
            // System.out.println(ele.get(i).getAttribute("href"));
            isValid = getResponseCode(ele.get(i).getAttribute("href"));
            if (isValid) {
            	Waitforpagetoload.wait(driver);
            	System.out.println("ValidLinks:"
                        + ele.get(i).getAttribute("href"));
            	
            } else {
            	driver.quit();
                System.out.println("InvalidLinks:"
                        + ele.get(i).getAttribute("href"));
            }
        }

    }

    public static boolean getResponseCode(String urlString) {
        boolean isValid = true;
        try {
            URL u = new URL(urlString);
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.connect();
          //  System.out.println(h.getResponseCode());
            if (h.getResponseCode() != 200) {
                isValid = false;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

}

