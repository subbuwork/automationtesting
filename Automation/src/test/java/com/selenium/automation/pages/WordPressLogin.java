package com.selenium.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.automation.utils.SeleniumUtil;

public class WordPressLogin {
	public static final String screenshots_location ="./screenshots/wordperss/newpost";
	@FindBy(how= How.XPATH,using="//*[@id='user_login']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(how =How.XPATH, using="//input[@name='pwd']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how =How.XPATH,using="//input[@id='wp-submit' or @name='wp-submit']")
	@CacheLookup
	WebElement loginButton;
	////*[@id="wp-admin-bar-logout"]/a
	
	@FindBy(how=How.XPATH, using="//*[text()='Howdy, admin']")
	@CacheLookup
	WebElement logOutMenu;
	
	@FindBy(how = How.XPATH, using=".//*[@id='wp-admin-bar-my-account']/a//following::a[3]")
	WebElement logout;
	
	@FindBy(how= How.XPATH, using="//*[@id='menu-posts']/a")
	WebElement menuBar;
	
	@FindBy(how = How.LINK_TEXT, using="post-new.php")
	WebElement addNewPost;
	
	WebDriver driver;
	
	public WordPressLogin(WebDriver webDriver){
		this.driver = webDriver;
	}
	
	
	public void login(String uid,String pass) throws Exception{
		System.out.println("UserName::"+uid+":::Password::"+pass);
		SeleniumUtil.takeScreenShot(driver, "wordpresslogInPage",screenshots_location);
		userName.sendKeys(uid);
		password.sendKeys(pass);
		loginButton.click();
		//driver.switchTo().alert().dismiss();
		//Thread.sleep(1000);
	}

	

	/*public void postComment()throws Exception{
	System.out.println("postComment()::::");
	Actions actions = new Actions(driver);
	//Thread.sleep(1000);
	actions.moveToElement(menuBar).perform();
	//webdriver.findElement(By.xpath("//*[@href='post-new.php']")).click();
	addNewPost.click();
	
	}*/
	
	public void logOut()throws Exception{
		System.out.println("Logging Out...");
		Actions actions = new Actions(driver);
		actions.moveToElement(logOutMenu).perform();
		Thread.sleep(1000);
		logout.click();
	}

}
