package Tryagain.target;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tryagain.target.PageAbstract.PageAbstractClass;


public class SearchproductflowTest extends PageAbstractClass {

	WebDriver driver;

	public SearchproductflowTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public SearchResultspageTest searchProducts() throws InterruptedException {
		driver.findElement(By.cssSelector("#search")).sendKeys("womens");
		/*
		 * List<WebElement> searchessuggestion = driver
		 * .findElements(By.xpath("//div[@class='sc-1b4dfcd0-1 iKPLJE notranslate']/h3")
		 * );
		 */

		List<WebElement> suggestions = driver
				.findElements(By.cssSelector(".styles_baseCell__zb2BN.styles_cellSkinny__Fjdj8.h-padding-l-none"));

		for (WebElement sugg : suggestions) {
			if (sugg.getText().contains("womens dresses")) {
				sugg.click();
				break;
			}
			Thread.sleep(2000);
		}
		SearchResultspageTest search=new SearchResultspageTest(driver);
		return search;
		
	}
}
