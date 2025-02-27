package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationcore.Base;

public class SubCategoryTest  extends Base{
	@Test(priority=1,description="Verification of adding  new items into the subcategory module")
	public void verifyAddNewItemToSubCategory()
	{	
	WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	userName.sendKeys("admin");
	
	WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
	password.sendKeys("admin");
	
	WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
	rememberMe.click();
	
	WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();
	WebElement subCategory = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']"));
	subCategory.click();

	WebElement addNewItem=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
	addNewItem.click();
	
	WebElement categorySelect=driver.findElement(By.xpath("//select[@id='cat_id']"));
	Select select=new Select(categorySelect);
	select.selectByIndex(7);
	
	WebElement subCategorySelect=driver.findElement(By.xpath("//input[@id='subcategory']"));
	subCategorySelect.sendKeys("tomatto");
	
//	WebElement chooseFile=driver.findElement(By.xpath("//input[@id='main_img']"));
//	chooseFile.sendKeys("C:\\Users\\PC\\eclipse-workspace\\7rMartProject\\src\\test\\resources\\beet.jpg");

	WebElement save=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	save.click();
	}

	@Test(priority=2,description="Verification of search an item in the subcategory list")
	public void verifySearchItemsFromSubCategory()
	{	
	WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
	userName.sendKeys("admin");
	
	WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
	password.sendKeys("admin");
	
	WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
	rememberMe.click();
	
	WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();
	WebElement subCategory = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']"));
	subCategory.click();
	
	WebElement search=driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
	search.click();
	
	WebElement category=driver.findElement(By.xpath("//select[@id='un']"));
	category.click();
	Select select=new Select(category);
	select.selectByIndex(10);
	
	WebElement subCategory1=driver.findElement(By.xpath("//input[@placeholder='Sub Category']"));
	subCategory1.sendKeys("chicken");
	
	WebElement search1=driver.findElement(By.xpath("//button[@name='Search']"));
	search1.click();
	

}
	@Test(priority=3,description="Verification of refresh functionality for the subcategory module")
	public void verifyResetSubCategoryPage()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin");
		
		WebElement rememberMe = driver.findElement(By.xpath("//label[@for='remember']"));
		rememberMe.click();
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		WebElement subCategory = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']"));
		subCategory.click();
		
		WebElement reset=driver.findElement(By.xpath("//i[@class='ace-icon fa fa-sync-alt']"));
		reset.click();
	}
}