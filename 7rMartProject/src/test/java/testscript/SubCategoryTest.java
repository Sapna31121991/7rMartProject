package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(priority = 1, description = "Verification of adding  new items into the subcategory module")
	public void verifywhetherUserIsAbleToAddNewItemToTheSubCategoryList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckBox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnAddNewButton();
		subCategory.clickOnCategoryFromDropDownMenu();
		String subCategoryselect = ExcelUtility.readStringData(3, 0, "SubCategoryPage");
		subCategory.enterSubCategoryOnSubCategoryField(subCategoryselect);
		subCategory.clickOnChooseFile();
		subCategory.clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = subCategory.getTextFromSubCategoryAlert();
		Assert.assertEquals(expectedResult, actualResult, Messages.ADDNEWITEMTOTHESUBCATEGORYLISTCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of search an item in the subcategory list")
	public void verifyWhetherUserIsAbleToSearchItemsFromSubCategoryList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckBox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnSearchButtonOnTheSubCategoru();
		subCategory.clickOnCategoryDropDownMenuForCategorysearch();
		String subCategorysearch = ExcelUtility.readStringData(4, 0, "SubCategoryPage");
		subCategory.enterSubcategoryForSearchSubCategory(subCategorysearch);
		subCategory.clickOnSearchButton();

		boolean isDisplayedSearchSubCategoryPage = subCategory.isDisplayedSearchSubCategoryPage();
		Assert.assertTrue(isDisplayedSearchSubCategoryPage, Messages.SEARCHITEMFROMSUBCATEGORYLISTCREDENTIALERROR);

	}

	@Test(priority = 3, description = "Verification of refresh functionality for the subcategory module")
	public void verifyWhtherUserIsAbleToRefreshPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckBox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategory();
		subCategory.clickOnResetButton();

		boolean isDisplayedRefreshSubCategoryPage = subCategory.isDisplayedRefreshSubCategoryPage();
		Assert.assertTrue(isDisplayedRefreshSubCategoryPage, Messages.REFRESHSUBCATEGORYPAGECREDENTIALERROR);

	}
}