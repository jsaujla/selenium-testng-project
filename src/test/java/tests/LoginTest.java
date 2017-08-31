package tests;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginAttemptPage;
import pages.UserLandingPage;

/**
 * @author Jaspal Aujla
 *
 */
public class LoginTest extends CommonSteps {
	
	private final HomePage homePage = new HomePage();
	private final UserLandingPage userLandingPage = new UserLandingPage();
	private final LoginAttemptPage loginAttemptPage = new LoginAttemptPage();
	
	@Test(description = "Verify login with valid credentials", enabled = true)
	private void verifyValidLogin() {
		super.deleteCookies();
		homePage.openHomePage(super.driver, super.baseUrl);
		homePage.login(super.driver, testDataFile.getProperty("ValidEmail"), testDataFile.getProperty("ValidPassword"));
		String actualText = userLandingPage.getTextFromUserProfileLink(super.driver);
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
	@Test(description = "Verify login with valid credentials 2", enabled = true)
	private void verifyValidLogin2() {
		super.deleteCookies();
		homePage.openHomePage(super.driver, super.baseUrl);
		homePage.login(super.driver, testDataFile.getProperty("ValidEmail"), testDataFile.getProperty("ValidPassword"));
		String actualText = userLandingPage.getTextFromUserProfileLink(super.driver);
		String expectedText = "Jaspal";
		Assert.assertEquals(expectedText, actualText);
		Reporter.log("Text verified successfully, which is equals to: " + expectedText, true);
	}
	
	@Test(description = "Verify login with invalid credentials", dataProvider = "InvalidLoginCredentials", enabled = false)
	private void verifyInvalidLogin(String loginEmail, String loginPassword, String errorMessage) {
		homePage.openHomePage(super.driver, super.baseUrl);
		homePage.login(super.driver, loginEmail, loginPassword);
		String actualErrorMessage = loginAttemptPage.getErrorMessage(super.driver);
		String expectedErrorMessage = errorMessage;
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@DataProvider(name = "InvalidLoginCredentials")	 
	private Object[][] invalidLoginCredentials() {
	//	return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
		Object[][] data = new Object[4][3];
		data[0][0] = testDataFile.getProperty("InvalidEmail1");
		data[0][1] = testDataFile.getProperty("InvalidPassword1");
		data[0][2] = testDataFile.getProperty("InvalidLoginExpectedError1");
		
		data[1][0] = testDataFile.getProperty("InvalidEmail2");
		data[1][1] = testDataFile.getProperty("InvalidPassword2");
		data[1][2] = testDataFile.getProperty("InvalidLoginExpectedError2");
		
		data[2][0] = testDataFile.getProperty("InvalidEmail3");
		data[2][1] = testDataFile.getProperty("InvalidPassword3");
		data[2][2] = testDataFile.getProperty("InvalidExpectedError3");
		
		data[3][0] = testDataFile.getProperty("InvalidEmail4");
		data[3][1] = testDataFile.getProperty("InvalidPassword4");
		data[3][2] = testDataFile.getProperty("InvalidLoginExpectedError4");
		
		return data;
	}
	
}
