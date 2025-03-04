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
	
	@FindBy(xpath="//p[text()='Sign in to start your session']")
	private WebElement startSession;

	public void clickOnAdminButton() {
		adminDropDown.click();
	} 

	public void clickOnLogoutButton() {
		logout.click();
	}
	public boolean isStartSessionTitleDisplayed()
	{
		return startSession.isDisplayed();
	}
}
