package testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationcore.Base;

public class AdminUsersTest extends Base{
	
	@Test(priority=1,description="Verification of adding a new user to the users list of the Admin Users module")
	public void verifyAddNewUserToManageUsersModule()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		WebElement adminUsers=driver.findElement(By.xpath("//i[@class='nav-icon fas fa-users']"));
		adminUsers.click();
		WebElement manageUser=driver.findElement(By.xpath("//p[text()='Manage Users']"));
		manageUser.click();
		
		WebElement addNewUser=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		addNewUser.click();
		
		WebElement userName1=driver.findElement(By.xpath("//input[@id='username']"));
		userName1.sendKeys("Samuel sam John");
		WebElement password1=driver.findElement(By.xpath("//input[@id='password']"));
		password1.sendKeys("heloo23");
		WebElement  userType=driver.findElement(By.xpath("//select[@id='user_type']"));
		Select select=new Select(userType);
		select.selectByIndex(2);
		WebElement save=driver.findElement(By.xpath("//i[@class='fa fa-save']"));
		save.click();
		
	}
	
	@Test(priority=2,description="Verification of searching an user from the users list of the Admin Users module")
	public void verifySearchUserFromManageUsersModule()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		WebElement adminUsers=driver.findElement(By.xpath("//i[@class='nav-icon fas fa-users']"));
		adminUsers.click();
		WebElement manageUser=driver.findElement(By.xpath("//p[text()='Manage Users']"));
		manageUser.click();
		WebElement search=driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
		search.click();
		
		WebElement serachUserName=driver.findElement(By.xpath("//input[@id='un']"));
		serachUserName.sendKeys("sam john");
		WebElement userType=driver.findElement(By.xpath("//select[@id='ut']"));
		Select select=new Select(userType);
		select.selectByIndex(2);
		WebElement search2=driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		search2.click();
	}

	@Test(priority=3,description="Verification of refreshing the page for Admin Users Module")
	public void verifyResetButtonForAdminUsersModule()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		WebElement adminUsers=driver.findElement(By.xpath("//i[@class='nav-icon fas fa-users']"));
		adminUsers.click();
		WebElement manageUser=driver.findElement(By.xpath("//p[text()='Manage Users']"));
		manageUser.click();
		
		WebElement reset=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-sync-alt']"));
		reset.click();
}
}