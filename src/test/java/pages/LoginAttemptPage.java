package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * @author Jaspal Aujla
 *
 */
public class LoginAttemptPage {
	
	private By locatorErrorMessage = By.xpath("//div[@class='_4rbf _53ij']");
	
	public String getErrorMessage(WebDriver driver) {
		String text = driver.findElement(locatorErrorMessage).getText();
		Reporter.log("Text captured from locator, " + locatorErrorMessage, true);
		return text;
	}

}
