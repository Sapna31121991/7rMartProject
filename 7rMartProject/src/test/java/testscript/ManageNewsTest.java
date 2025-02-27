package testscript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationcore.Base;

public class ManageNewsTest extends Base {

	@Test(priority = 1,description="Verification of creating a new news into the Manage News module")
	public void verifyAddNewNewsToManageNews() {

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");

		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		WebElement manageNews = driver.findElement(By.xpath(
				"//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'  or @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		manageNews.click();

		WebElement addNews = driver.findElement(By.xpath("//a[@onclick='click_button(1)']"));
		addNews.click();

		WebElement news = driver.findElement(By.xpath("//textarea[@id='news']"));
		news.sendKeys("News about fire");

		WebElement save = driver.findElement(By.xpath("//button[@name='create']"));
		save.click();
	}

	@Test(priority = 2,description="Verification of searching a news from the Manage News Module")
	public void verifySearchNewsFromManageNews() {

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");

		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		WebElement manageNews = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'  or @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		manageNews.click();

		WebElement search = driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
		search.click();

		WebElement title = driver.findElement(By.xpath("//input[@name='un']"));
		title.sendKeys("News about fire");

		WebElement search1 = driver.findElement(By.xpath("//button[@type='submit']"));
		search1.click();

	}

	@Test(priority = 3,description="Verification of refreshing functionality for Manage News page")
	public void verifyResetButtonForManageNews() 
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");

		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();

		WebElement manageNews = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'  or @href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		manageNews.click();

		WebElement reset = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-sync-alt']"));
		reset.click();
	}
}