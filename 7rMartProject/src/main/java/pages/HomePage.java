package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement adminDropDown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;

	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement startSession;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement subCategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'  or @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsers;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUser;

	public SubCategoryPage clickOnSubCategory() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}

	public ManageNewsPage clickOnManageNewsButton() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}

	public HomePage clickOnAdminusersButton() {
		adminUsers.click();
		return this;
	}

	public AdminUsersPage clickOnManageUsersButton() {
		manageUser.click();
		return new AdminUsersPage(driver);
	}

	public HomePage clickOnAdminButton() {
		adminDropDown.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logout.click();
		return new LoginPage(driver);
	}

	public boolean isStartSessionTitleDisplayed() {
		return startSession.isDisplayed();
	}
}
