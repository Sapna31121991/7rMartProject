package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'  or @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newNews;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement createNewsField;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement save;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement titleField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchNews;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	private WebElement reset;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement newNewsAlert;
	@FindBy(xpath = "//th[text()='News']")
	private WebElement searchNewsTitle;
	@FindBy(xpath = "//h1[text()='Manage News']")
	private WebElement refresh;
	public ManageNewsPage clickOnManageNewsButton() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}

	public ManageNewsPage clickOnNewButtonForCreateNews() {
		newNews.click();
		return this;
	}

	public ManageNewsPage createNewsOnTheCreateNewsFields(String createNews) {
		createNewsField.sendKeys(createNews);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		save.click();
		return this;
	}

	public ManageNewsPage clickOnSearchButtonOnManageNews() {
		search.click();
		return this;
	}

	public ManageNewsPage entertitleOnTheTitleField(String tile) {
		titleField.click();
		return this;
	}

	public ManageNewsPage clickOnSearchButton() {
		searchNews.click();
		return this;
	}

	public ManageNewsPage clickOnResetButton() {
		reset.click();
		return this;
	}

	public String gettextFromAlert() {
		return newNewsAlert.getText();
	}

	public boolean isDisplayedSearchPage() {
		return searchNewsTitle.isDisplayed();
	}

	public boolean isDisplayedManagenewsPage() {
		return refresh.isDisplayed();
	}
}
