package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class MosturizersPage extends TestBase {
	
	
	public void addRandomItems(int count) {
		for (int i = 1; i <= count; i++) {
		String loc = 	"(//button[@class='btn btn-primary'])["+i+"]";
		clickByxpath(loc);
			
		}
	}
	
	public void clickCartButton() {
		clickByxpath(prop.getProperty("cartButton"));
		
	}

	
	public void validateRowSize(int count) {
		
		List<WebElement> rows = driver.findElements(By.tagName("tr")); 
		System.out.println(rows.size());
		int size = rows.size()-1;
		assertTrue(size == count );
	}
	
	public void clickPay() throws InterruptedException {
		Thread.sleep(3000);
		clickBylinkText("Pay with Card");
	}
	
	public void validateStripe() throws InterruptedException {
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.linkText("Stripe.com")).isDisplayed());
	}
}
