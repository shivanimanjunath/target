package Tryagain.target;

import java.io.IOException;

import org.testng.annotations.Test;

import Tryagin.target.TestComponents.BaseTest;


public class targetpurchasetest extends BaseTest{

	SearchproductflowTest productsearch;	
	   
	@Test(priority=1)
	public void loginsuccessfull() throws IOException, InterruptedException {
		Thread.sleep(5000);
		
		LoginpageTest loginflow = homescreen.NavigatetoSignInScreen();
		productsearch=loginflow.login();
	}

	@Test(priority=2)
	public void verifypurchaseflow() throws InterruptedException {
    
		SearchResultspageTest search=productsearch.searchProducts();
		SelectProductandAddToCartTest AtoC=search.searchResultpage();
		PaymentpageTest pay=AtoC.selectProductDetails();
		pay.creditCardPaymentmessage();
		
	}

}
