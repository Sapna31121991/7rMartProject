package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utilities.PageUtility;
public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement addNewItem;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryselect;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveSubCategory;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement search;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement categorySearch;
	@FindBy(xpath = "//input[@placeholder='Sub Category']")
	private WebElement subCategorysearch;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement search1;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	private WebElement reset;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement newSubCategory;
	@FindBy(xpath = "//h4[text()='List Sub Categories']")
	private WebElement searchSubCategory;
	@FindBy(xpath = "//h4[text()='List Sub Categories']")
	private WebElement refresh;
	public SubCategoryPage clickOnSubCategory() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}

	public SubCategoryPage clickOnAddNewButton() {
		addNewItem.click();
		return this;
	}

	public SubCategoryPage clickOnCategoryFromDropDownMenu() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(categoryselect, 4);
		return this;
	}

	public SubCategoryPage enterSubCategoryOnSubCategoryField(String subCategorySelect) {
		subCategoryField.sendKeys(subCategorySelect);
		return this;
	}

	public SubCategoryPage clickOnChooseFile() {
		chooseFile.sendKeys(Constants.IMAGEFILE);
		return this;
	}

	public SubCategoryPage clickOnSaveButton() {
		saveSubCategory.submit();
		return this;
	}

	public SubCategoryPage clickOnSearchButtonOnTheSubCategoru() {
		search.click();
		return this;
	}

	public SubCategoryPage clickOnCategoryDropDownMenuForCategorysearch() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(categorySearch, 11);
		return this;
	}

	public SubCategoryPage enterSubcategoryForSearchSubCategory(String subCategorySearch) {
		subCategorysearch.click();
		return this;
	}

	public SubCategoryPage clickOnSearchButton() {
		search1.click();
		return this;
	}

	public SubCategoryPage clickOnResetButton() {
		reset.click();
		return this;
	}

	public String getTextFromSubCategoryAlert() {
		return newSubCategory.getText();
	}

	public boolean isDisplayedSearchSubCategoryPage() {
		return searchSubCategory.isDisplayed();
	}

	public boolean isDisplayedRefreshSubCategoryPage() {
		return refresh.isDisplayed();
	}
}
