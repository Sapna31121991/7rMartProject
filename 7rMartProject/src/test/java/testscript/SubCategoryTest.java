package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "Verification of adding  new items into the subcategory module")
	public void verifywhetherUserIsAbleToAddNewItemToTheSubCategoryList() throws IOException {

		SubCategoryPage subCategory;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		subCategory = home.clickOnSubCategory();

		String subCategoryselect = ExcelUtility.readStringData(3, 0, "SubCategoryPage");
		subCategory.clickOnSubCategory().clickOnAddNewButton().clickOnCategoryFromDropDownMenu()
				.enterSubCategoryOnSubCategoryField(subCategoryselect).clickOnChooseFile().clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = subCategory.getTextFromSubCategoryAlert();
		Assert.assertEquals(expectedResult, actualResult, Messages.ADDNEWITEMTOTHESUBCATEGORYLISTCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of search an item in the subcategory list")
	public void verifyWhetherUserIsAbleToSearchItemsFromSubCategoryList() throws IOException {
		SubCategoryPage subCategory;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		subCategory = home.clickOnSubCategory();
		String subCategorysearch = ExcelUtility.readStringData(4, 0, "SubCategoryPage");
		subCategory.clickOnSearchButtonOnTheSubCategoru().clickOnCategoryDropDownMenuForCategorysearch()
				.enterSubcategoryForSearchSubCategory(subCategorysearch).clickOnSearchButton();

		boolean isDisplayedSearchSubCategoryPage = subCategory.isDisplayedSearchSubCategoryPage();
		Assert.assertTrue(isDisplayedSearchSubCategoryPage, Messages.SEARCHITEMFROMSUBCATEGORYLISTCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of refresh functionality for the subcategory module")
	public void verifyWhtherUserIsAbleToRefreshPageUsingResetButton() throws IOException {
		SubCategoryPage subCategory;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnCheckBox();
		home = login.clickOnSignInButton();
		subCategory = home.clickOnSubCategory().clickOnResetButton();

		boolean isDisplayedRefreshSubCategoryPage = subCategory.isDisplayedRefreshSubCategoryPage();
		Assert.assertTrue(isDisplayedRefreshSubCategoryPage, Messages.REFRESHSUBCATEGORYPAGECREDENTIALERROR);

	}
}