package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author Jaspal
 *
 */
public class CommonSteps {
	
	protected WebDriver driver;
	protected String baseUrl;
	
	@BeforeTest
	@Parameters({"browser", "baseUrl"})
	public void beforeClass(String browserName, String baseUrl)
	{
		this.baseUrl = baseUrl;
		launchBrowser(browserName);
		Reporter.log("Browser (" + browserName + ") launched", true);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Implicit wait implemented", true);
	}
	
	@AfterTest
	public void afterClass()
	{
		driver.quit();
		Reporter.log("Browser and session quit", true);
	}
	
	private void launchBrowser(String browserName) {
		if(browserName.toLowerCase().contains("firefox")) {
			if(System.getProperty("webdriver.gecko.driver") == null){
	        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browser drivers/geckodriver.exe");	
	        	driver = new FirefoxDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("chrome")) {
			if(System.getProperty("webdriver.chrome.driver") == null){
	        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser drivers/chromedriver.exe");
	        	driver = new ChromeDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("ie")) {
			if(System.getProperty("webdriver.ie.driver") == null){
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/browser drivers/IEDriverServer.exe");
	        	driver = new InternetExplorerDriver(capabilities);
	        }
		}
		else if(browserName.toLowerCase().contains("edge")) {
			if(System.getProperty("webdriver.edge.driver") == null){
	        	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browser drivers/MicrosoftWebDriver.exe");
	        	driver = new EdgeDriver();
	        }
		}
	}
	
	protected void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
}
