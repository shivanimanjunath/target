package Tryagain.target;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Tryagain.target.PageAbstract.PageAbstractClass;

public class SelectProductandAddToCartTest extends PageAbstractClass{

	WebDriver driver;

	public SelectProductandAddToCartTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public PaymentpageTest selectProductDetails() throws InterruptedException {
		List<WebElement> colour = driver
				.findElements(By.xpath("//li[@class='sc-a26a6bf9-3 kobkMm']/a/div/div/div/picture/img"));
		for (WebElement q : colour) {
			if (q.getAttribute("alt").contains("Black/White Floral")) {
				q.click();
			}
		}

		List<WebElement> size = driver
				.findElements(By.xpath("//ul[@class='sc-a26a6bf9-2 hLqQDk']/li[@class='sc-a26a6bf9-3 kobkMm']/a"));

		for (WebElement s : size) {
			if (s.getText().contains("M")) {
				s.click();
				break;
			}
		}

		Thread.sleep(4000);
		WebElement j = driver.findElement(By.xpath(
				"//div[@id='above-the-fold-information']/div[8]/div/div[@aria-label='Fulfillment']/div/div/div[2]/div/div/div/button/span[1]"));

		super.javaScriptElement().executeScript("arguments[0].scrollIntoView()", j);
		j.click();

		super.explicitWait()
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-5a11d645-0.gPhogk")));

		driver.findElement(By.xpath("//ul[@class='sc-5a11d645-0 gPhogk']/li/a[@aria-label='2']")).click();

		driver.findElement(By.xpath(
				"//div[@id='above-the-fold-information']/div[8]/div/div[@aria-label='Fulfillment']/div/div/div[2]/div/button"))
				.click();

		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//span[@class='h-text-lg']")).getText().contains("Added to cart"));

		driver.findElement(By.cssSelector("a[class='sc-9306beff-0 sc-e6042511-0 dfqbQr ibmrHV']")).click();
		driver.findElement(By.cssSelector("button[class='sc-9306beff-0 sc-d6c67707-0 dfqbQr cfcjLp']")).click();

		Thread.sleep(4000);
		
		PaymentpageTest pay=new PaymentpageTest(driver);
		return pay;

	}
}
