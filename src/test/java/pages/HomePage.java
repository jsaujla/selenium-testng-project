package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * @author Jaspal Aujla
 *
 */
public class HomePage {
	
	private By locatorEmailTextbox = By.id("email");
	private By locatorPasswordTextbox = By.id("pass");
	private By locatorLoginButton = By.id("loginbutton");
	
	public void openHomePage(WebDriver driver, String baseUrl) {
		driver.get(baseUrl);
		Reporter.log("Application opened with baseUrl, which is: " + baseUrl, true);
	}
	
	public void login(WebDriver driver, String email, String password) {
		driver.findElement(locatorEmailTextbox).clear();
		Reporter.log("Value cleared in email textbox located by, " + locatorEmailTextbox, true);
		driver.findElement(locatorEmailTextbox).sendKeys(email);
		Reporter.log("Value filled in email textbox located by, " + locatorEmailTextbox, true);
		driver.findElement(locatorPasswordTextbox).clear();
		Reporter.log("Value cleared in password textbox located by, " + locatorPasswordTextbox, true);
		driver.findElement(locatorPasswordTextbox).sendKeys(password);
		Reporter.log("Value filled in password textbox located by, " + locatorPasswordTextbox, true);
		driver.findElement(locatorLoginButton).click();
		Reporter.log("Clicked on login button located by, " + locatorLoginButton, true);
	}
	
}
