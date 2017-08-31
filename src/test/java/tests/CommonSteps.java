package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
 * @author Jaspal Aujla
 *
 */
public class CommonSteps {
	
	protected WebDriver driver;
	protected String baseUrl;
	protected Properties testDataFile;
    private FileInputStream fileInputStream;
	
	@BeforeTest
	@Parameters({"browser", "implicitlyWait", "baseUrl"})
	protected void beforeClass(String browserName, int implicitlyWaitTime, String baseUrl) {
		testDataFile = loadPropertiesFile(testDataFile, System.getProperty("user.dir") + "/test data/testData.properties");
		this.baseUrl = baseUrl;
		launchBrowser(browserName);
		Reporter.log("Browser (" + browserName + ") launched", true);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		Reporter.log("Implicit wait implemented", true);
	}
	
	@AfterTest
	protected void afterClass() {
		driver.quit();
		Reporter.log("Browser and session quit", true);
	}
	
	protected void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	private void launchBrowser(String browserName) {
		if(browserName.toLowerCase().contains("firefox")) {
			if(System.getProperty("webdriver.gecko.driver") == null) {
	        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browser drivers/geckodriver.exe");	
	        	driver = new FirefoxDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("chrome")) {
			if(System.getProperty("webdriver.chrome.driver") == null) {
	        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser drivers/chromedriver.exe");
	        	driver = new ChromeDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("ie") || browserName.toLowerCase().contains("internet explorer")) {
			if(System.getProperty("webdriver.ie.driver") == null) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/browser drivers/IEDriverServer.exe");
	        	driver = new InternetExplorerDriver(capabilities);
	        }
		}
		else if(browserName.toLowerCase().contains("edge")) {
			if(System.getProperty("webdriver.edge.driver") == null) {
	        	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browser drivers/MicrosoftWebDriver.exe");
	        	driver = new EdgeDriver();
	        }
		}
	}
	
	private Properties loadPropertiesFile(Properties propertiesObject, String filePath) {
        try {
        	propertiesObject = new Properties();
            fileInputStream = new FileInputStream(filePath);
            propertiesObject.load(fileInputStream);
            return propertiesObject;
        }
        catch (IOException io) {
            io.printStackTrace();
            return null;
        }
        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
    }
	
}
