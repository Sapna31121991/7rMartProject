package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "Verification of creating a new news by the user into the Manage News list")
	public void verifyWhetherUserIsAbleToCreateNewNewsToTheManageNewsList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		ManageNewsPage manageNews;
		manageNews = home.clickOnManageNewsButton();
		String createNews = ExcelUtility.readStringData(3, 0, "ManageNewsPage");
		manageNews.clickOnNewButtonForCreateNews().createNewsOnTheCreateNewsFields(createNews).clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = manageNews.gettextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.CREATENEWSTOMANAGENEWSLISTCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of searching a news by the user from the list of created news list")
	public void verifyWhetherUserIsAbleToSearchNewsFromManageNewsList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();

		ManageNewsPage manageNews;
		manageNews = home.clickOnManageNewsButton();
		String titleNews = ExcelUtility.readStringData(3, 0, "ManageNewspage");
		manageNews.clickOnSearchButtonOnManageNews().entertitleOnTheTitleField(titleNews).clickOnSearchButton();

		boolean isDisplayedSearchPage = manageNews.isDisplayedSearchPage();
		Assert.assertTrue(isDisplayedSearchPage, Messages.SEARCHNEWSFROMMANAGENEWSLISTCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of refreshing functionality for Manage News page")
	public void verifyWhetherUserIsAbleToRefreshManageNewsPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();

		ManageNewsPage manageNews;
		manageNews = home.clickOnManageNewsButton().clickOnResetButton();

		boolean isDisplayedManageNewsPage = manageNews.isDisplayedManagenewsPage();
		Assert.assertTrue(isDisplayedManageNewsPage, Messages.REFRESHMANAGENEWSPAGECREDENTIALERROR);
	}
}