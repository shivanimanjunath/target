package Tryagain.target;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Tryagain.target.PageAbstract.PageAbstractClass;

public class PaymentpageTest extends PageAbstractClass {
	
	WebDriver driver;

	public PaymentpageTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void creditCardPaymentmessage() throws InterruptedException {
		List<WebElement> payment = driver.findElements(By.xpath(
				"//fieldset[@class='sc-bda06be7-1 guHFFQ']/div[contains(@class,'sc-3747e8f4-3 euHARl sc-719d6eec-1 lhLmgm')]/div[@class='sc-3747e8f4-0 jCYPdH']"));

		for (WebElement pay : payment) {

			if (pay.findElement(By.xpath("./label/span/span[@class='h-text-bs']")).getText()
					.contains("Credit or debit card")) {
				pay.findElement(By.xpath("./input")).click();
				driver.findElement(By.xpath(" //input[@id='credit-card-number-input']")).sendKeys("1111111111111111");
				driver.findElement(By.xpath("//input[@id='credit-card-expiration-input']")).click();
				Thread.sleep(2000);
				String x=driver.findElement(By.xpath("//span[@id='credit-card-number-input--ErrorMessage']")).getText();
				Assert.assertEquals(x,"Please enter a valid credit card number");
				
			}
		}
	}


}
