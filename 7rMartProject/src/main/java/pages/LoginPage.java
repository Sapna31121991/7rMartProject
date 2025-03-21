package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// page factory is a class,initElements is a method to initialize values
												// or elements
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMe;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;
	
	@FindBy(xpath="//p[text()='Dashboard']") 
	private WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") 
	private WebElement title;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") 
	private WebElement titleWindow;
	
	public LoginPage enterUserNameOnUserNameField(String username) {
		userNameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public LoginPage clickOnCheckBox() {
		PageUtility page=new PageUtility();
		page.handlingCheckBox(rememberMe);
		return this;
	}

	public HomePage clickOnSignInButton() {
		signIn.click();
		return new HomePage(driver);
	}
	public boolean isDashBoardDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	public boolean isTitleDisplayed()
	{
		return title.isDisplayed();
	}
	public boolean isTitleWindowDisplayed()
	{
		return titleWindow.isDisplayed();
	}

	
	////h5[contains(text(),'Alert!')]
	//h5[contains(text(),'Alert!')]
}
