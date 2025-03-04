package testscript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description="Verification of logout functionality from the home page after successful login")
	public void verifySuccessfulUserLogoutFromHomePageAfterLogin() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0,"LoginPage");
		String password=ExcelUtility.readStringData(1, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckBox();
		login.clickOnSignInButton();
		
		
		HomePage home=new HomePage(driver);
		home.clickOnAdminButton();
		home.clickOnLogoutButton();
		boolean isStartSessionDisplayed=home.isStartSessionTitleDisplayed();
		Assert.assertTrue(isStartSessionDisplayed,Messages.USERLOGOUTCREDENTIALERROR);
	}

}
