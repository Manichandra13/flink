package com.crm.qa.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {

	public void validatepresenceHomePage() {
		
		
		assertTrue(driver.findElement(By.xpath(prop.getProperty("Hometext"))).isDisplayed());
	}
	
	public void clickBuyMosturizers() {
	clickByxpath(prop.getProperty("BuyMoisturizer"));
	
		
	}
	
	public void getTemperature() {
	String tempA = 	driver.findElement(By.id(prop.getProperty("temperatureID"))).getText();
	driver.navigate().refresh();
	String tempB = driver.findElement(By.id(prop.getProperty("temperatureID"))).getText();
	assertFalse(tempA.equalsIgnoreCase(tempB));
		
	}
	
}
