package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xslf.model.geom.IfElseExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		String osType = System.getProperty("os.name");
		
		
		if(browserName.equalsIgnoreCase("chrome") && System.getProperty("os.name").contains("Mac")) {
		

	
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
			
		//	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");	
			driver = new ChromeDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("chrome") && System.getProperty("os.name").contains("Windows")) {
			
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		
		
	
		else if(browserName.equals("FF")  && System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		else if (browserName.equals("FF")  && System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}

		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		String userName = prop.getProperty("username");
		String passWord = prop.getProperty("password");
		String link = prop.getProperty("url");
		
		String UrlBuilder = "https://"+userName+":"+passWord+"@"+link;
		
		System.out.println(UrlBuilder);
				
			//	https://candidatex:qa-is-cool@qa-task.backbasecloud.com
		
		//driver.get(UrlBuilder);
		
	driver.get(prop.getProperty("url"));
		
	}
	
	
	//Business Functions
	
	public void clickByxpath(String xpathLoc) {
		driver.findElement(By.xpath(xpathLoc)).click();
	}
	
	public void clickBylinkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	
	
	
	
	
	
	

}
