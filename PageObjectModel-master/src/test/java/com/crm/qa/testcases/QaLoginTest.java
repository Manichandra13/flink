package com.crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.QaHomePage;
import com.crm.qa.pages.QaLoginPage;

public class QaLoginTest extends TestBase {

	
	QaLoginPage qaLoginPage;
	QaHomePage qaHomePage;
	
	
	
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		qaLoginPage = new QaLoginPage();
		qaHomePage = new QaHomePage();
	}
	
	@AfterMethod
	public void endSession() {
		driver.close();
	}
	
	
	@Test(description = "A Test Scenario for Positive Login test")
	public void loginTest() throws InterruptedException {
		Thread.sleep(3000);
	
		qaLoginPage.clickSignIn();
		qaLoginPage.enterEmailID("emailID");
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaHomePage.validateHomepgaePresence();
			
	}
	
	@Test(description =  "A test Scenario for Login with Wrong Password")
	
	public void loginTestWithWrongpassword() throws InterruptedException {
		
		qaLoginPage.clickSignIn();
		qaLoginPage.enterEmailID("emailID");
		qaLoginPage.enterpassword("wrongpass");
		qaLoginPage.clickSIgnInButton();
		qaLoginPage.errorMessageValidation();
		
		
	}
	
	
	
}
