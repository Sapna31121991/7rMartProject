package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.Base;

public class LoginTest extends Base {
	
	

	@Test(priority=1,description="Verification of login with valid username and valid password")
	public void verifyUserLoginWithValidUsernameAndValidPassword() {
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

	}
	
	@Test(priority=2,description="Verification of login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admi");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
	}
	
	@Test(priority=3,description="Verification of login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("dmin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
	}
	
	@Test(priority=4,description="Verification of login with invalid username and invalid password")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("dmin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admi");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
	}
}
