package AJALogin;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.support.ui.Select;

import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;
import AJALogin.abc;


public class CreateCase {
public WebDriver driver;
public void login()
{
/*driver=new FirefoxDriver();*/
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
driver.get("https://10.200.0.20/rcms");
driver.manage().window().maximize();
driver.findElement(By.id("txtUserName")).sendKeys("05050889");
driver.findElement(By.id("txtPassword")).sendKeys("Titp42015!");
driver.findElement(By.id("btnLogin")).click();
}
public void casecreation() throws InterruptedException
    {
       driver.findElement(By.linkText("Create Case")).click();	
       
       driver.findElement(By.id("ctl00_MainContentPlaceHolder_NameTextBox")).sendKeys("Test Case");
       
       new Select(driver.findElement(By.id("ctl00_MainContentPlaceHolder_CoursesDropDown"))).selectByVisibleText("Abdominal");
       
       /*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
       new Select(driver.findElement(By.id("ctl00_MainContentPlaceHolder_Category1DropDown"))).selectByVisibleText("Abdominal");
       
       driver.findElement(By.id("ctl00_MainContentPlaceHolder_SubmitButton")).click();
       /*driver.findElement(By.id("ctl00_MainContentPlaceHolder_KeywordsTextBox")).sendKeys("Rasmussen’s encephalitis");
       driver.findElement(By.id("ctl00_MainContentPlaceHolder_SubmitButton")).click();*/
	}
public void images() throws InterruptedException
    {Thread.sleep(5000);
	  driver.findElement(By.linkText("Images")).click();
	  
	  driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td/form/div[4]/table/tbody/tr/td[4]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[1]/fieldset[2]/fieldset/div/div/div[2]/input")).sendKeys("C:\\Users\\skrishnakanth\\Downloads\\maxresdefault.jpg");
	  Thread.sleep(5000);
	  driver.findElement(By.name("ctl00$MainContentPlaceHolder$EditImageGroup$uploadImageId$DisplayDescCB")).click();
	  
		driver.switchTo().frame("txtImageDescriptionId_ifr");
		
		driver.findElement(By.id("tinymce")).sendKeys("C1");
		
		/*driver.switchTo().parentFrame();*/
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("btnSaveCapAndMod")).click();
		
		Thread.sleep(5000);
		
	}
/*public void textitems() throws InterruptedException
{
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_ViewCaseHeader_CaseTextItemsLink")).click();
	Thread.sleep(7000);
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_lnkHistory")).click();
	Thread.sleep(9000);
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_TextElementContainer_btnAddTextItem")).click();
    driver.switchTo().frame("ctl00_MainContentPlaceHolder_TextElementContainer_rprTextElement_ctl00_EditText_txbText_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("Pathology-Proven Intramedullary Spinal Cord Tuberculoma");
    driver.switchTo().parentFrame();
    Thread.sleep(3000);
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_TextElementContainer_rprTextElement_ctl00_EditText_btnSave")).click();
}

public void questions() throws InterruptedException
{
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_ViewCaseHeader_CaseQuestionsLink")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_QuestionContainer_btnCreateQuestion")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_EditQuestion_rbMultiQuestion")).click();
    Thread.sleep(3000);
    driver.switchTo().frame("ctl00_MainContentPlaceHolder_EditQuestion_rtxtStem_txtText_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("Adams-DeWeese partial occlusion IVC clip");
    driver.switchTo().parentFrame();
    driver.findElement(By.id("ctl00_MainContentPlaceHolder_EditQuestion_btnAddQuestion")).click();
    Thread.sleep(3000);
    driver.switchTo().frame("txtAnswers0_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("C1");
    driver.switchTo().parentFrame();
    driver.switchTo().frame("txtAnsExplanation0_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("E1");
    driver.switchTo().parentFrame();
    driver.switchTo().frame("txtAnswers1_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("C2");
    driver.switchTo().parentFrame();
    driver.switchTo().frame("txtAnsExplanation1_ifr");
    driver.findElement(By.id("tinymce")).sendKeys("E2");
    driver.switchTo().parentFrame();
    driver.findElement(By.id("chkIsCorrect1")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("btnUpdate")).click();
    Thread.sleep(5000);
}*/
public void Templateditems() throws InterruptedException
{
	driver.findElement(By.linkText("Templated Items")).click();
	
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_btnTemplatedItemAdd")).click();
	
	new Select(driver.findElement(By.id("ctl00_MainContentPlaceHolder_cbxAddTemplatedItem"))).selectByVisibleText("Simple Image Viewer");
	
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_btnCreateTemplatedItem")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_simpleImageViewerId_editImageListForTemplateId_WorkflowItemActionButtons_btnAdd")).click();
	Set<String> handles = driver.getWindowHandles(); // get all window handles
	Iterator<String> iterator = handles.iterator();
	/*while (iterator.hasNext()){*/
	String parentWindowHandler=iterator.next();
	   String subWindowHandler = iterator.next();
	    
	/*}*/
	driver.switchTo().window(subWindowHandler); // switch to popup window
	driver.findElement(By.id("btnSelectAll")).click();
	driver.findElement(By.id("btnInsertId")).click();
	Thread.sleep(5000);
	driver.switchTo().window(parentWindowHandler);
	
    // perform operations on popup

driver.switchTo().window(parentWindowHandler);  // switch back to parent window
		
		}	

public void popuphandler(WebDriver driver) throws InterruptedException
{
	Thread.sleep(5000);
	/*String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	String subWindowHandler = null;*/

	Set<String> handles = driver.getWindowHandles(); // get all window handles
	Iterator<String> iterator = handles.iterator();
	/*while (iterator.hasNext()){*/
	String parentWindowHandler=iterator.next();
	   String subWindowHandler = iterator.next();
	    
	/*}*/
	driver.switchTo().window(subWindowHandler); // switch to popup window
	driver.findElement(By.id("ctl00_MainContentPlaceHolder_simpleImageViewerId_editImageListForTemplateId_WorkflowItemActionButtons_btnAdd")).click();
	driver.switchTo().window(parentWindowHandler);
	
    // perform operations on popup

driver.switchTo().window(parentWindowHandler);  // switch back to parent window
}

	public static void main(String[] args) throws InterruptedException {
		
CreateCase c= new CreateCase();
c.login();
c.casecreation();
c.images();
/*c.textitems();
c.questions();*/
c.Templateditems();
abc test=new abc();
test.add();
	}

}
