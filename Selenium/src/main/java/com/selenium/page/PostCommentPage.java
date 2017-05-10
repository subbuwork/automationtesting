package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.java.selenium.utils.SeleniumUtil;

/**
 * @author subbu
 *
 */
public class PostCommentPage {
	public static final String screenshots_location ="./screenshots/wordpress/newpost"; 
	WebDriver webdriver;
	public PostCommentPage(WebDriver webDriver){
		this.webdriver = webDriver;
		
	}
	
	@FindBy(how= How.XPATH, using="//*[@id='menu-posts']/a")
	WebElement menuBar;
	
	@FindBy(how= How.XPATH,using="//*[@id='menu-posts']/child::div[3]/div/ul/child::li[2]/a")
	WebElement addNewPost;
	
	@FindBy(how = How.XPATH, using="//input[@name='post_title']")
	WebElement postTitle;
	
	@FindBy(how = How.XPATH, using="//textarea[@id='content']")
	WebElement postContent;
	
	@FindBy(how = How.XPATH, using="//*[@id='post-preview']")
	WebElement preview;
	
	@FindBy(how = How.XPATH, using="//*[@id='submit']")
	WebElement postComment;
	
	@FindBy(how=How.XPATH,using="//*[@id='publish']")
	WebElement publish;
	
	@FindBy(how = How.XPATH, using="//*[@id='publish']")
    WebElement update;
	
	@FindBy(how = How.XPATH, using="//a[text()='View post']")
	WebElement viewPost;
	
	/**
	 * Posting new post in wordpress web site..
	 * @throws Exception
	 */
	public void postComment()throws Exception{
	System.out.println("postComment()::::");
	SeleniumUtil.takeScreenShot(webdriver, "dashBoard",screenshots_location);
	Thread.sleep(1500);
	Actions actions = new Actions(webdriver);
	actions.moveToElement(menuBar).perform();
	Thread.sleep(1000);
	addNewPost.click();
	SeleniumUtil.takeScreenShot(webdriver, "newPost",screenshots_location);
	postTitle.sendKeys("Subbu_Demo3");
	postContent.sendKeys("Demo Post from subbu-selenium");
	SeleniumUtil.takeScreenShot(webdriver, "newPostWithContentToPost",screenshots_location);
	//preview.click();
	Thread.sleep(1000);
	publish.click();
	//submit.click();
	Thread.sleep(1500);
	//update.click();
	
	}
	/**
	 * updating post on the same page after creating  new post in wordpress web site..
	 * @throws Exception
	 */
	public void udpateCommentOnSamePage()throws Exception{
		System.out.println("udpateComment()::::");
		update.click();
		SeleniumUtil.takeScreenShot(webdriver, "updateCommentPage",screenshots_location);
		postContent.clear();
		postContent.sendKeys("Updated Demo Post from subbu-selenium_3");
		update.click();
		//Thread.sleep(1000);
		//viewPost.click();
	}

}
