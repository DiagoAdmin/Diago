package ajatest;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import AJALogin.LoginUsers;
import sqlconnection.SqlConnection;
import sqlconnection.sqlconnectionajadb;
import wait.Waitforpagetoload;
public class Login
{
	WebDriver driver;
	@BeforeSuite
	public void dbTest() throws IOException
	{
		SqlConnection.dbConnect(driver);
		}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	@Test
	public void login() throws Exception
	{
		LoginUsers lu=new LoginUsers();
		lu.AJALogin(driver);
		
		}
	/*@Test()
	private final void asserttest()
	{
		try
		{
			Assert.assertEquals("ACRJournal Advisor", "ACRJournal Adviso");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
			}
		}
	@Test
	private final void asserttest1()
	{
		try
		{
			Assert.assertEquals("ACR Journal Advisor: More Than Research", "ACR Journal Advisor: More Than Researc");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		}
	@Test
	private final void testCaseSkipException()
	{
		throw new SkipException("Skipping this exception");
		}*/
	
	
/*	@Test
	public void testCaseConditionalSkipException(){
		System.out.println("Im in Conditional Skip");
		if(!DataAvailable)
		throw new SkipException("Skipping this exception");
		System.out.println("Executed Successfully");
	}*/
	
	
	@AfterMethod
	public void tearDown() throws Exception 
	{
		Waitforpagetoload.wait(driver);
		driver.close();
		driver.quit();
	}
	

	@AfterSuite
	public void dbClose()
	{
		SqlConnection.dbConnectionClose();
		sqlconnectionajadb.dbConnectionClose();
		
	}
}


//List<WebElement> txtfields = driver.findElements(By.xpath("//input[@type='text' or @type='password']"));