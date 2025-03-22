package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Verification of login with valid username and valid password", groups = {
			"smoke" }, retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox()
				.clickOnSignInButton();
		boolean isDashBoardDisplayed = login.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, Messages.VALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of login with valid username and invalid password", groups = {
			"smoke" })
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox()
				.clickOnSignInButton();
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDPASSWORDCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox()
				.clickOnSignInButton();
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDUSERNAMECREDENTIALERROR);

	}

	@Test(priority = 4, description = "Verification of login with invalid username and invalid password", dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox()
				.clickOnSignInButton();
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "adin", "admin" }, new Object[] { "admin", "ad12" },
				new Object[] { "admi", "admin" }, new Object[] { "admi", "ami" } };
	}
}
