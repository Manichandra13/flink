package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.MosturizersPage;
import com.crm.qa.pages.QaHomePage;
import com.crm.qa.pages.QaLoginPage;

public class ProcessTest extends TestBase {
/* The Test case validate the presennce of the homepage, clicks the buy mosturizer and validates the respective page,
 * Validates and adds Items to the cart.
 * Validate the number of items added in the cart is equal to the no of items displayed inn the final web table
 * Validates temperature changes on refresh
 */
	
	Homepage homePage;
	MosturizersPage mosturizerPage;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new Homepage();
		mosturizerPage = new MosturizersPage();
	}
	
	@AfterMethod
	public void endSession() {
		driver.close();
	}
	
//	@Test(description =  "Validates the changes of Temperature")
//	public void validate_temperature_Changes_on_Refresh() {
//		
//		homePage.getTemperature();
//		
//	}
//	
	@Test
	public void validate_Cart_process_till_payment() throws InterruptedException {
		
		homePage.validatepresenceHomePage();
		homePage.clickBuyMosturizers();
		int count =3;
		mosturizerPage.addRandomItems(count);
		mosturizerPage.clickCartButton();
		mosturizerPage.validateRowSize(count);
		mosturizerPage.clickPay();
		mosturizerPage.validateStripe();
	}
	
	
	
	
	
}
