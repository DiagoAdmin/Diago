package SSL_Handler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;*/
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class SSLCertificate {
 
public void sslhandle(WebDriver driver) {
	// Create object of DesiredCapabilities class
	DesiredCapabilities cap=DesiredCapabilities.chrome();
	 
	// Set ACCEPT_SSL_CERTS  variable to true
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 
	// Set the driver path
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	 
	// Open browser with capability
	driver=new ChromeDriver(cap);
 
/*//It create firefox profile
FirefoxProfile profile=new FirefoxProfile();
 
// This will set the true value
profile.setAcceptUntrustedCertificates(true);
 
// This will open  firefox browser using above created profile
WebDriver driver=new FirefoxDriver();
 
driver.get("pass the url as per your requirement");*/
 
 
}
 
}