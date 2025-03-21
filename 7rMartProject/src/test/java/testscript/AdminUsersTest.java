package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "Verification of adding a new admin user information to the users list by the user")
	public void verifyWhetherUserIsAbleToAddNewUserToTheUsersList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		AdminUsersPage adminUsers;
		home.clickOnAdminusersButton();
		FakerUtility faker = new FakerUtility();
		String userNameAdmin = faker.createRandomUserName();
		String passwordAdmin = faker.createRandomPassword();
		adminUsers = home.clickOnManageUsersButton().clickOnAddNewAdminUsersInformations()
				.enterUserNameOnUserNameAdminField(userNameAdmin).enterPasswordOnPasswordAdminField(passwordAdmin)
				.clickOnUserTypeFromDropDownMenu().clickOnSaveButton();
		String expectedResult = "Alert!";
		String actualResult = adminUsers.getTextFromAdminUsersAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.ADDNEWUSERSTOTHEUSERSLISTCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of searching an user informations from the list of created admin user information list")
	public void verifyUserIsAbleToSearchUsersInTheNewlyAddedUsersList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		AdminUsersPage adminUsers;
		home.clickOnAdminusersButton();
		String adminUserName = ExcelUtility.readStringData(2, 0, "AdminUsersPage");
		adminUsers = home.clickOnManageUsersButton().clickOnSearchUsersAdminInformations()
				.enterSearchAdminUsersUsername(adminUserName).clickOnSearchUserTypeFromDropDownMenu()
				.clickOnSearchButton();
		boolean isDisplayedAdminUsersPage = adminUsers.isDisplayedAdminUsersPage();
		Assert.assertTrue(isDisplayedAdminUsersPage, Messages.SEARCHUSERSFROMUSERSLISTCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of refreshing the page for Admin Users Module")
	public void verifyUserIsAbleToRefreshNewlyAddedUserPageUsingTheResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		AdminUsersPage adminUsers;
		home.clickOnAdminusersButton();
		adminUsers = home.clickOnManageUsersButton();
		adminUsers.clickOnResetButtonForAdminUsers();
		boolean isdisplayedRefreshPageForAdminUsers = adminUsers.isDisplayedRefreshPageForAdminUsers();
		Assert.assertTrue(isdisplayedRefreshPageForAdminUsers, Messages.REFRESHUSERSPAGECREDENTIALERROR);

	}
}