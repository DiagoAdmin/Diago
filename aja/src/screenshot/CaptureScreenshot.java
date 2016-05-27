package screenshot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class CaptureScreenshot {
       WebDriver driver;
       @Before
       public void setUp() throws Exception {
    	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
   		driver = new ChromeDriver();
    	   
    	  // driver = new FirefoxDriver();
            driver.get("http://10.200.0.63");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
     }
     @After
     public void tearDown() throws Exception {
            driver.quit();
     }
     @Test
     public void test() throws IOException {
            // Code to capture the screenshot
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Code to copy the screenshot in the desired location
FileUtils.copyFile(scrFile, new File("C:\\CaptureScreenshot\\home.jpg"));                  
     }
}