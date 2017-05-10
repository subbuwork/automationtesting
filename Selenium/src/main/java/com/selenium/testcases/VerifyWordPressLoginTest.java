package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.java.selenium.utils.BrowserFactory;
import com.selenium.page.WordPressLogin;

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
