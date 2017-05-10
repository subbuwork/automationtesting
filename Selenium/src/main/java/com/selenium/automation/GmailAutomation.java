package com.selenium.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.selenium.utils.SeleniumUtil;


public class GmailAutomation {
	public static final String screenshots_location ="./screenshosts/gmail";
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://mail.google.com/mail/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	@Test
	public void gmailLogin() throws InterruptedException{
		//driver.findElement(By.cssSelector("a.gmail-nav__nav-link:nth-child(2)")).click();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#Email")).sendKeys("subbu.varsith1@gmail.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#next")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#Passwd")).sendKeys("machavaram123");
		driver.findElement(By.cssSelector("#signIn")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#gb_71")).click();
		
	}
	
	@AfterMethod
	public void tearDownBrowser(ITestResult result){
		if(ITestResult.SUCCESS == result.getStatus()){
			System.out.println(result.getName()+"::Test success::"+result.getStatus());
			SeleniumUtil.takeScreenShot(driver,result.getName(),screenshots_location);
		}else{
			System.out.println(result.getName()+"::Test fail::"+result.getStatus());
			SeleniumUtil.takeScreenShot(driver,result.getName(),screenshots_location);
		}
		driver.close();
		driver.quit();
	}
	

}
