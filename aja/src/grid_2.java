import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;
public class grid_2 {
WebDriver driver;
String baseUrl, nodeURL;
@BeforeTest
public void setUp() throws MalformedURLException, InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "D:\\krishna back up\\selenium\\JARS\\chromedriver.exe");
	File file = new File("D:\\krishna back up\\selenium\\JARS\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	driver = new ChromeDriver();
	
	baseUrl="http://10.200.0.63";
	Thread.sleep(1000);
	/*nodeURL="http://10.200.2.118:5525/wd/hub";*/
	
	
	DesiredCapabilities cp=DesiredCapabilities.chrome();
	
	cp.setBrowserName(cp.getBrowserName());
	Platform s=Platform.getCurrent();
	cp.setPlatform(s);
	nodeURL="http://10.200.2.120:5555/wd/hub";
	driver=new RemoteWebDriver(new URL(nodeURL),cp);
}
@AfterTest
public void afterTest()
{
driver.quit();
}
@Test
public void simpleTest()
{
	driver.get(baseUrl);
	Assert.assertEquals("ACRJournal Advisor", driver.getTitle());
}
}
