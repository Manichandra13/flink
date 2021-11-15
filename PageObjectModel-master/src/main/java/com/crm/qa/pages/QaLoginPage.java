package com.crm.qa.pages;

import org.openqa.selenium.By.ByLinkText;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class QaLoginPage  extends TestBase{
	
	
//Locators	

	
	public void clickSignIn() {
		driver.findElement(By.linkText(prop.getProperty("signInButtons"))).click();;
	}
	
	public void clickSignUp() {
		driver.findElement(By.linkText(prop.getProperty("signupButtons"))).click();
	}
	
	public void enterEmailID(String emailID) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("emailtextField"))).sendKeys(prop.getProperty("emailID"));
	}
	
	public void enterEmailIDwithSIgnup(String mail) {
		driver.findElement(By.xpath(prop.getProperty("emailtextField"))).sendKeys(prop.getProperty(mail));
	}
	

	
	public void enterpassword(String passwordvalue) {
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(passwordvalue);
	}
	
	public void clickSIgnInButton() {
		driver.findElement(By.xpath(prop.getProperty("signInButton"))).click();
	}
	
	public void errorMessageValidation() {
		if (driver.findElement(By.xpath(prop.getProperty("errorMessage"))).isDisplayed()) {			
			Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("errorMessage"))).getText().equalsIgnoreCase(prop.getProperty("errorMessageText")));
		}
		
	}

	
	public String enterUsername() {
		String randomUserName = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
	
		driver.findElement(By.xpath(prop.getProperty("userName"))).sendKeys(randomUserName);
		return randomUserName;
	}
	
	
	public String emailIDGenerator() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		String generatedEmailId = "username"+ randomInt +"@test.com";   
		
		return generatedEmailId;
	}
	
	
	public void validateErrorForSignUp() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath(prop.getProperty("errorMessage"))).isDisplayed());
	
		
	}

	

}
