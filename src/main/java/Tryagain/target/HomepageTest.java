package Tryagain.target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Tryagain.target.PageAbstract.PageAbstractClass;



public class HomepageTest extends PageAbstractClass{

WebDriver driver;
	
	
	public HomepageTest(WebDriver driver)
	{
	   super(driver);
	   this.driver=driver;		
	}
	
	public void LandOn()
	{
		driver.get("https://www.target.com/");
	}
	
	public LoginpageTest NavigatetoSignInScreen() throws InterruptedException
	{		
		Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@aria-label='Account, sign in']")).click();
        driver.findElement(By.xpath("//a[@data-test='accountNav-signIn']")).click();
		Thread.sleep(2000);
		return new LoginpageTest(driver);		
		
	}
	
}
