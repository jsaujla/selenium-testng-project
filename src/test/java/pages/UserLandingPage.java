package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * @author Jaspal Aujla
 *
 */
public class UserLandingPage {
	
	private By locatorUserProfileLink = By.xpath("//div[@data-click='profile_icon']");
	
	public String getTextFromUserProfileLink(WebDriver driver) {
		String text = driver.findElement(locatorUserProfileLink).getText();
		Reporter.log("Text captured from locator, " + locatorUserProfileLink, true);
		return text;
	}
	
}
