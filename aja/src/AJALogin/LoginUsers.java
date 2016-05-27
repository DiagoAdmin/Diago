package AJALogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.Reading_Properties;
import Assert_AJA.assert_Medline_Title;
import ajatest.UserValidationPopup;
import wait.*;
import sqlconnection.SqlConnection;
public class LoginUsers
{
	public void AJALogin(WebDriver driver) throws SQLException, InterruptedException {
		
		try
		{
			Boolean flag = true;
			if (flag)
			{
				Connection conn = SqlConnection.dbConnect(driver);
				Statement statement = conn.createStatement();
				Reading_Properties rp=new Reading_Properties();
				rp.LoadProperties(driver);
				String queryString = rp.getPropertyValue("loginusers");
				ResultSet rs = statement.executeQuery(queryString);
				Waitforpagetoload.wait(driver);
				
				driver.get(rp.getPropertyValue("diagodomainurl"));
				driver.manage().window().maximize();
				
				/*driver.findElement(By.xpath(rp.getPropertyValue("homelogin"))).click();*/
				ResultSetMetaData metadata = rs.getMetaData();
				int columnCount = metadata.getColumnCount();
				for (int i=0; i<=columnCount; i++)
				{
					while(rs.next())
					{
						String columnval1=rs.getString(2);
						String columnval2=rs.getString(3);
						driver.findElement(By.name(rp.getPropertyValue("username"))).sendKeys(columnval1);
						driver.findElement(By.name(rp.getPropertyValue("password"))).sendKeys(columnval2);
						driver.findElement(By.xpath(rp.getPropertyValue("loginpagebtn"))).click();
						/*driver.findElement(By.name(rp.getPropertyValue("loginpagebtn"))).click();*/
						Waitforpagetoload.wait(driver);
						/*UserValidationPopup.windowhandle(driver);*/
						driver.findElement(By.xpath(rp.getPropertyValue("Group"))).click();
						Manage_Group.Branches.Create_Branch(driver);					
						Waitforpagetoload.wait(driver);
						assert_Medline_Title aMt=new assert_Medline_Title();
						aMt.title_assert(driver);
						Waitforpagetoload.wait(driver);
						
						Waitforpagetoload.wait(driver);
						driver.findElement(By.xpath(rp.getPropertyValue("logout"))).click();
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