package tests;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLandingPage;

/**
 * @author Jaspal
 *
 */
public class TestLogin extends CommonSteps {
	
	private final HomePage homePage = new HomePage();
	private final UserLandingPage userLandingPage = new UserLandingPage();
	
	@Test(description = "Verify login with valid credentials", enabled = true)
	@Parameters({"loginEmail", "loginPassword"})
	private void verifyValidLogin(String loginEmail, String loginPassword)
	{
		super.deleteCookies();
		homePage.openHomePage(super.driver, super.baseUrl);
		homePage.login(super.driver, loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink(super.driver);
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
	@Test(description = "Verify login with valid credentials 2", enabled = true)
	@Parameters({"loginEmail", "loginPassword"})
	private void verifyValidLogin2(String loginEmail, String loginPassword)
	{
		super.deleteCookies();
		homePage.openHomePage(super.driver, super.baseUrl);
		homePage.login(super.driver, loginEmail, loginPassword);
		String actualText = userLandingPage.getTextFromUserProfileLink(super.driver);
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
}
