/**
 * 
 */
package com.selenium.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.automation.pages.PostCommentPage;
import com.selenium.automation.pages.WordPressLogin;
import com.selenium.automation.utils.BrowserFactory;
import com.selenium.automation.utils.SeleniumUtil;



/**
 * @author subbu
 *
 */
public class PostCommentsTest {
	
	WebDriver driver;
	
	@Test
	public void postingComments()throws Exception{
		
		driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
		//SeleniumUtil.takeScreenShot(driver, "wordPressHomePage");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		WordPressLogin loginPage =PageFactory.initElements(driver,WordPressLogin.class);
		loginPage.login("admin","demo123");
		Thread.sleep(5000);
		//SeleniumUtil.takeScreenShot(driver, "wordPressLoggedInPage");
		PostCommentPage postPage = PageFactory.initElements(driver, PostCommentPage.class);
		postPage.postComment();
		//postPage.udpateCommentOnSamePage();
		Thread.sleep(3000);
		loginPage.logOut();
		Thread.sleep(3000);
		SeleniumUtil.takeScreenShot(driver,"wordPressLogOutPage","./screenshots/wordpress/newpost");
		BrowserFactory.tearDownBrowser(driver);
	}

}
