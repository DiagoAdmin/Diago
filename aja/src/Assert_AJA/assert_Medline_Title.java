package Assert_AJA;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import Excel.Test_Reports_Excel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sqlconnection.sqlconnectionajadb;
import wait.Waitforpagetoload;
import config.Reading_Properties;

public class assert_Medline_Title
{ 
	//define an Excel Work Book
	  HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	  
	  //define a test result data object
	  Map<String, Object[]> testresultdata;
	  public void title_assert(WebDriver driver) throws IOException, InterruptedException
	{
		Test_Reports_Excel tre=new Test_Reports_Excel();
    	tre.CreateResult(null);
		Waitforpagetoload.wait(driver);
		Reading_Properties rp=new Reading_Properties();
		rp.LoadProperties(driver);
		Waitforpagetoload.wait(driver);
		
		try
		{
		Boolean flag = true;
		if (flag)
		{
			Connection conn = sqlconnectionajadb.dbConnect(driver);
			Statement statement = conn.createStatement();
		    String queryString = "SELECT * FROM [Cogent3].[dbo].[iCitation] where UpdateSource=1226";
		    ResultSet rs = statement.executeQuery(queryString);
		    /*ResultSetMetaData metadata = rs.getMetaData();
		    int columnCount = metadata.getColumnCount();
		    for (int i=0; i<=columnCount; i++)
		    {*/
		    	while(rs.next())
		    	{
		    		String columnval1=rs.getString(1);
		        	Statement statement1 = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		           	String queryString1="SELECT ltrim(rtrim(articletitle)) FROM [Cogent3].[dbo].[iWideNew] where PMID='"+columnval1+"'";
		           	ResultSet rs1 = statement1.executeQuery(queryString1);
		           /*	ResultSetMetaData metadata1 = rs1.getMetaData();
			        int columnCount1 = metadata1.getColumnCount();
			        
			        for (int j=0; j<=columnCount1; j++) {*/
			        while(rs1.next()) 
			        {
			        String columnval2=rs1.getString(1);
				    driver.findElement(By.xpath(rp.getPropertyValue("Search_Medline"))).click();
				    Waitforpagetoload.wait(driver);
				    WebElement ab=driver.findElement(By.id(rp.getPropertyValue("Search_Medline_search_txtBox")));
				    ab.clear();
				    ab.sendKeys(columnval1);
				    Waitforpagetoload.wait(driver);
				    WebElement dropdown_id=driver.findElement(By.id(rp.getPropertyValue("Search_Medline_dropdown")));
				    Waitforpagetoload.wait(driver);
					Select s1=new Select(dropdown_id);
					s1.selectByVisibleText("PMID");
					Waitforpagetoload.wait(driver);
					driver.findElement(By.id(rp.getPropertyValue("Search_Medline_searchBtn"))).click();
					Waitforpagetoload.wait(driver);
					Waitforpagetoload.wait(driver);
				    driver.findElement(By.xpath(rp.getPropertyValue("ExpandTitle"))).click();
				    Waitforpagetoload.wait(driver);
				    String abstract_text=driver.findElement(By.xpath(rp.getPropertyValue("ExpandTitle_AbstractText"))).getText();
				    String abst=abstract_text.trim();
				    try
				    {
				    	Verify_Test vt=new Verify_Test();
				    	Waitforpagetoload.wait(driver);
				    	vt.verifyTest(columnval2, abst);
				    	Waitforpagetoload.wait(driver);
				    	Waitforpagetoload.wait(driver);
				    	tre.Result(columnval2,abst);
				    	Waitforpagetoload.wait(driver);
				    	tre.WriteResult();
				    	}
				    catch(Exception e)
				    {
				    	continue;
				    }
				    
				    }
			        }
		}
		}
			    catch (Exception e) 
		{
			e.printStackTrace();
			}
		
}
}