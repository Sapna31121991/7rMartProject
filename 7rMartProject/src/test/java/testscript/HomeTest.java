package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.Base;

public class HomeTest extends Base
{
	
	@Test(description="Verification of logout functionality from the home page")
	public void verifyUserLogoutFromPage()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		WebElement adminDropDown=driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
		adminDropDown.click();
		
		WebElement logout=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logout.click();
	}
	
}
		
		
