package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsers;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement addNewUser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameAdminField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordAdminField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement save;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchAdminUsers;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchAdminUserNameField;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButton;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	private WebElement resetAdminUsers;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement createNewUser;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement searchAdminUser;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	private WebElement refresh;

	public void clickOnAdminusersButton() {
		adminUsers.click();
	}

	public void clickOnManageUsersButton() {
		manageUser.click();
	}

	public void clickOnAddNewAdminUsersInformations() {
		addNewUser.click();
	}

	public void enterUserNameOnUserNameAdminField(String userNameAdmin) {
		userNameAdminField.sendKeys(userNameAdmin);
	}

	public void enterPasswordOnPasswordAdminField(String passwordAdmin) {
		passwordAdminField.sendKeys(passwordAdmin);
	}

	public void clickOnUserTypeFromDropDownMenu() {
		Select select = new Select(userType);
		select.selectByIndex(2);
		userType.click();
	}

	public void clickOnSaveButton() {
		save.click();
	}

	public void clickOnSearchUsersAdminInformations() {
		searchAdminUsers.click();
	}

	public void enterSearchAdminUsersUsername(String adminUserName) {
		searchAdminUserNameField.sendKeys(adminUserName);
	}

	public void clickOnSearchUserTypeFromDropDownMenu() {
		Select select = new Select(searchUserType);
		select.selectByIndex(2);
		searchUserType.click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnResetButtonForAdminUsers() {
		resetAdminUsers.click();
	}

	public String getTextFromAdminUsersAlert() {
		return createNewUser.getText();
	}

	public boolean isDisplayedAdminUsersPage() {
		return searchAdminUser.isDisplayed();
	}

	public boolean isDisplayedRefreshPageForAdminUsers() {
		return refresh.isDisplayed();
	}
}
