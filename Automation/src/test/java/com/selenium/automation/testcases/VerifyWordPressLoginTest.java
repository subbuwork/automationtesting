package com.selenium.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.automation.pages.WordPressLogin;
import com.selenium.automation.utils.BrowserFactory;

public class VerifyWordPressLoginTest {

	
	WebDriver driver;
	
	@Test
	public void verifyLogin()throws Exception{
		driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
		
		WordPressLogin login =PageFactory.initElements(driver, WordPressLogin.class);
		login.login("admin","demo123");
		
		//login.postComment();
		
		Thread.sleep(8000);
		
		login.logOut();
		
		//CreateDriver.tearDownBrowser(driver);
		
		
	}
	
	
}
