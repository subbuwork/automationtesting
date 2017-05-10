package com.selenium.automation.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.automation.utils.ActionsUtils;
import com.selenium.automation.utils.SeleniumUtil;

/**
 * @author subbu
 *
 */
public class UpdatePostPage {
	
	public static final String screenshots_location="./screenshots/wordperss/updatepost";
	WebDriver driver;
	
	@FindBy(how= How.XPATH, using="//*[@id='menu-posts']/a")
	//@CacheLookup
	WebElement menuBar;
	
	@FindBy(how = How.XPATH, using="//*[@id='menu-posts']/div[3]/div/ul/li[1]/a")
	//@CacheLookup
	WebElement allPosts;
	
	@FindBy(how = How.XPATH, using="//table/tbody/tr/td/strong/a[text()='Demo Title - Draft']")
	//@CacheLookup
	WebElement selectPost;
	
	@FindBy(how = How.XPATH,using="//table/tbody/tr/td/div[1]/span[1]/a")
	//@CacheLookup
	WebElement editPost;
	
	@FindBy(how = How.XPATH,using="//input[@id='title' or @name='post_title']")
	//@CacheLookup
	WebElement title;
	
	@FindBy(how = How.XPATH, using="//textarea[@id='content']")
	//@CacheLookup
	WebElement content;
	
	@FindBy(how = How.XPATH,using="//input[@id='publish']")
	//@CacheLookup
	WebElement publish;
	
	//@FindBy(how = How.XPATH, using="//*[@id='menu-posts']/div[3]/div/ul/li[1]/a")
	
	public UpdatePostPage(WebDriver webDriver){
		this.driver = webDriver;
	}
	
	
	
	public void updatePost(String updateTitle,String post){
		try{
	SeleniumUtil.takeScreenShot(driver, "dashBorad",screenshots_location);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	ActionsUtils.mouseOverOperation(driver, menuBar);
	/*Actions actions = new Actions(driver);
	actions.moveToElement(menuBar).perform();*/
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	allPosts.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	ActionsUtils.mouseOverOperation(driver, selectPost);
	//selectPost.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	editPost.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	title.sendKeys(updateTitle);
	content.sendKeys(post);
	publish.click();
	allPosts.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
