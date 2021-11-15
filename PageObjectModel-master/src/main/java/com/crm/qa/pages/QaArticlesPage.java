package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.crm.qa.base.TestBase;

public class QaArticlesPage extends TestBase {

	
	
	public void validateArticleTitle(String title) {
		
	//	System.out.println(driver.findElement(By.xpath("//div[@class = 'container']")).getText());
		String text = driver.findElement(By.xpath("//*[@class='container']/h1")).getAttribute("innerHTML");
		
		assertTrue(text.equalsIgnoreCase(title));

		
		//assertTrue(driver.findElement(By.linkText(title)).isDisplayed());
	}
	
	
	public void validateArticle(String articles) {
		//assertTrue(driver.findElement(By.linkText(articles)).isDisplayed());
		
		
	}
	
	
	
	public String generateArticleTitle() {
		String articleTitle = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
	
		
		return articleTitle;
	}
	
	
	public void enterArticleTitle(String articleTitle) {
		driver.findElement(By.xpath(prop.getProperty("ArticleTitle"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("ArticleTitle"))).sendKeys(articleTitle);
	}
	
	public void enterArticle(String Article) {
		driver.findElement(By.xpath(prop.getProperty("Article"))).sendKeys(Article);
	}
	
	
	public void clickEditArticle() {
		driver.findElement(By.xpath(prop.getProperty("editArticle"))).click();
	}
	
	public void clickGlobalFeed() {
		driver.findElement(By.xpath(prop.getProperty("GlobalFeed"))).click();
		
	}
	
	public void clickHeart() {
		System.out.println(driver.findElement(By.xpath(prop.getProperty("heartIcon"))).getText());
		String ttt = driver.findElement(By.xpath(prop.getProperty("heartIcon"))).getText();
		driver.findElement(By.xpath(prop.getProperty("heartIcon"))).click();
	}
	
}
