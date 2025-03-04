package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public void enterUserNameOnUserNameField(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnCheckBox() {
		rememberMe.click();
	}

	public void clickOnSignInButton() {
		signIn.click();
	}
	public boolean isDashBoardDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	public boolean isTitleDisplayed()
	{
		return title.isDisplayed();
	}

}
