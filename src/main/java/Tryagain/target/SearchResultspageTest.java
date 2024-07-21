package Tryagain.target;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Tryagain.target.PageAbstract.PageAbstractClass;




public class SearchResultspageTest extends PageAbstractClass {


	WebDriver driver;

	public SearchResultspageTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public SelectProductandAddToCartTest searchResultpage() throws InterruptedException {
		WebElement paginationdropdown = driver
				.findElement(By.xpath("//div[@class='sc-5da3fdcc-0 iNQaAr']/div/div/div[2]/div/button"));
		 Thread.sleep(4000);

		paginationdropdown.click();

		super.explicitWait()
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-5a11d645-0.gPhogk")));
		List<WebElement> pagination = driver.findElements(By
				.xpath("//ul[@class='sc-5a11d645-0 gPhogk']/li/a[@class='sc-676073c3-0 sc-39f216d3-0 fCfUJD fwcWmg']"));
		super.action().moveToElement(paginationdropdown).click().build().perform();
		System.out.println(pagination.size());
		int i = 0;

		first: while (i < pagination.size()) {
			super.explicitWait().until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sc-f82024d1-0 NQtvb']")));
			Thread.sleep(2000);
			List<WebElement> dresses = driver.findElements(By.xpath(
					"//section[@class='sc-e56884d9-1 ixTNme']/div[@class='sc-5da3fdcc-0 cqdDWw']/div[@class='sc-f82024d1-0 rLjwS']"));
			System.out.println(dresses.size() + i);
			for (int j = 0; i < dresses.size(); j++) {
				super.javaScriptElement().executeScript("arguments[0].scrollIntoView()", dresses.get(j));
				// System.out.println(dresses.get(j).findElement(By.xpath("./div/div/div/div[2]/div/div/div[1]/div[1]/div[1]")).getAttribute("title"));
				if (dresses.get(j).findElement(By.xpath("./div/div/div/div[2]/div/div/div[1]/div[1]/div[1]/a"))
						.getText().contains("Women's Maxi Sundress - A New Day™")) {
					Thread.sleep(4000);
					dresses.get(j).findElement(By.xpath("./div/div/div/div[2]/div/div/div[1]/div[1]/div[1]")).click();
					// flag=true;
					break first;
				}
				if (j == dresses.size() - 1) {
					driver.findElement(By.xpath("//div[@class='sc-9572954b-4 eEvByy']/button[@aria-label='next page']"))
							.click();
					i++;
					Thread.sleep(4000);
					break;
				} else
					continue;
			}
	
}
		SelectProductandAddToCartTest Atoc=new SelectProductandAddToCartTest(driver);
		return Atoc;

	
}
}