package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath ="//button[text()='Save']")
	private WebElement saveSubCategory;
	
	@FindBy(xpath ="//a[@href='javascript:void(0)']")
	private WebElement search;
	@FindBy(xpath ="//select[@id='un']")
	private WebElement categorySearch ;
	@FindBy(xpath ="//input[@placeholder='Sub Category']")
	private WebElement subCategorysearch ;
	@FindBy(xpath ="//button[@name='Search']")
	private WebElement search1 ;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")
	private WebElement reset;
	
	@FindBy(xpath="//h5[text()=' Alert!']")
	private WebElement newSubCategory;
	@FindBy(xpath="//h4[text()='List Sub Categories']")
	private WebElement searchSubCategory;
	@FindBy(xpath="//h4[text()='List Sub Categories']")
	private WebElement refresh;

	public void clickOnSubCategory() {
		subCategory.click();
	}

	//add
	public void clickOnAddNewButton() {
		addNewItem.click();
	}

	public void clickOnCategoryFromDropDownMenu() {
		Select select = new Select(categoryselect);
		select.selectByIndex(5);
		categoryselect.click();
	}

	public void enterSubCategoryOnSubCategoryField(String subCategorySelect) {
		subCategoryField.sendKeys(subCategorySelect);
	}

	public void clickOnChooseFile() {
		chooseFile.sendKeys("C:\\Users\\PC\\git\\7rMartProject\\7rMartProject\\src\\test\\resources\\hele.jpg");
	}

	public void clickOnSaveButton()
	{
		saveSubCategory.submit();
		}

	//search
	public void clickOnSearchButtonOnTheSubCategoru() {
		search.click();
	}

	public void clickOnCategoryDropDownMenuForCategorysearch() {
		Select select = new Select(categorySearch);
		select.selectByIndex(11);
		categorySearch.click();
	}

	public void enterSubcategoryForSearchSubCategory(String subCategorySearch) {
		subCategorysearch.click();
	}

	public void clickOnSearchButton() {
		search1.click();
	}
	
	//reset
	public void clickOnResetButton()
	{
		reset.click();
	}
	public String getTextFromSubCategoryAlert()
	{
		return newSubCategory.getText();
	}
	public boolean isDisplayedSearchSubCategoryPage()
	{
		return searchSubCategory.isDisplayed();
	}
	public boolean isDisplayedRefreshSubCategoryPage()
	{
		return refresh.isDisplayed();
	}
}
