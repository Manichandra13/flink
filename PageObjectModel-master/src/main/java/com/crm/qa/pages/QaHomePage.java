package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.crm.qa.base.TestBase;

public class QaHomePage  extends TestBase {

	public void validateHomepgaePresence() {
		
		
		assertTrue(driver.findElement(By.linkText(prop.getProperty("Hometext"))).isDisplayed());
		
	}
	
	
	public void validateUserNameDIsplayed(String username) {
		
assertTrue(driver.findElement(By.xpath(prop.getProperty("UsernameDisplay"))).getText().equalsIgnoreCase(username));

		
	}
	
	public void clickNewArticle() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NewArticle"))).click();

	}
	
	public void publish() {
		driver.findElement(By.xpath(prop.getProperty("Publish"))).click();
	}
	
	
	
	
}
