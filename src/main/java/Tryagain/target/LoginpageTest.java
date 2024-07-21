package Tryagain.target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Tryagain.target.PageAbstract.PageAbstractClass;

public class LoginpageTest extends PageAbstractClass{

WebDriver driver;
	
	
	public LoginpageTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
	}
	
	public SearchproductflowTest login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("shivani.manjunath@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shivu1996?");
		driver.findElement(By.xpath("//button[@id='login']")).click();
	
		SearchproductflowTest search=new SearchproductflowTest(driver);
		return search;
        
	}
}
