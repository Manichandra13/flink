package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.QaHomePage;
import com.crm.qa.pages.QaLoginPage;
import com.github.javafaker.Faker;


public class SignUpTest extends TestBase {
	

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
	
	
	@Test
	public void signUpwithnewCreds() throws InterruptedException {
		
	
		qaLoginPage.clickSignUp();
		String UserNameGenerated = qaLoginPage.enterUsername();
		String EmailFOrRegistration = 	qaLoginPage.emailIDGenerator();	
		Thread.sleep(2000);
	     
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(EmailFOrRegistration);

		

		
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaHomePage.validateHomepgaePresence();
		qaHomePage.validateUserNameDIsplayed(UserNameGenerated);
		
		
	}
	
	@Test
	public void signUpWithoutUserName() throws InterruptedException {
		
		qaLoginPage.clickSignUp();
		String EmailFOrRegistration = 	qaLoginPage.emailIDGenerator();	
		qaLoginPage.enterEmailID(EmailFOrRegistration);
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaLoginPage.validateErrorForSignUp();
	
	}
	
	
	
}
