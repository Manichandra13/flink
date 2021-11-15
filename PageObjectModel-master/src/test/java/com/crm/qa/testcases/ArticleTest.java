package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.QaArticlesPage;
import com.crm.qa.pages.QaHomePage;
import com.crm.qa.pages.QaLoginPage;

public class ArticleTest extends TestBase {

	QaLoginPage qaLoginPage;
	QaHomePage qaHomePage;
	QaArticlesPage qaArticlePage;
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		qaLoginPage = new QaLoginPage();
		qaHomePage = new QaHomePage();
		qaArticlePage = new QaArticlesPage();
	}
	
	
	@AfterMethod
	public void endSession() {
		driver.close();
	}
	
	@Test(description = "validate the user is able to create a Article")
	
	public void createNewArticle() throws InterruptedException {
		qaLoginPage.clickSignIn();
		qaLoginPage.enterEmailID("emailID");
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaHomePage.validateHomepgaePresence();
		qaHomePage.clickNewArticle();
		
		
		String Articletitle = qaArticlePage.generateArticleTitle();
		String ArticleAbout = qaArticlePage.generateArticleTitle();
		String Article = qaArticlePage.generateArticleTitle();
		
		qaArticlePage.enterArticleTitle(Articletitle);
		qaArticlePage.enterArticle(Article);
		
		
		qaHomePage.publish();
	
		qaArticlePage.validateArticleTitle(Articletitle);
	
	}
	
	@Test(description = "Validate the User is able to Edit the Article")
	
	public void editArticle() throws InterruptedException {
		
		qaLoginPage.clickSignIn();
		qaLoginPage.enterEmailID("emailID");
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaHomePage.validateHomepgaePresence();
		qaHomePage.clickNewArticle();
		
		
		String Articletitle = qaArticlePage.generateArticleTitle();
		String ArticleAbout = qaArticlePage.generateArticleTitle();
		String Article = qaArticlePage.generateArticleTitle();
		
		qaArticlePage.enterArticleTitle(Articletitle);
		qaArticlePage.enterArticle(Article);
		
		
		qaHomePage.publish();
	
		qaArticlePage.validateArticleTitle(Articletitle);
		
		
		qaArticlePage.clickEditArticle();
		String Articletitle1 = qaArticlePage.generateArticleTitle();
		qaArticlePage.enterArticleTitle(Articletitle1);
		qaHomePage.publish();
		
		qaArticlePage.validateArticleTitle(Articletitle1);
	
	}
	
	@Test(description = "Validate User is able to Like a Article")
	
	public void likeArticle() throws InterruptedException {
		
		
		qaLoginPage.clickSignIn();
		qaLoginPage.enterEmailID("emailID");
		qaLoginPage.enterpassword("newnewnew");
		qaLoginPage.clickSIgnInButton();
		qaHomePage.validateHomepgaePresence();
		
		qaArticlePage.clickGlobalFeed();
		
		qaArticlePage.clickHeart();
	}
	
	
	
	
}
