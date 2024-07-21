package Tryagain.target.PageAbstract;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAbstractClass {

WebDriver driver;
	
	public PageAbstractClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Actions action()
	{
		Actions a=new Actions(driver);
		return a;
	}
	
	public JavascriptExecutor javaScriptElement()
	{
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		return jse;
	}
	
	public WebDriverWait explicitWait()
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		return w;
	}

	
}
