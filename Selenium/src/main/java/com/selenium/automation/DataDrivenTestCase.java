package com.selenium.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestCase {
    WebDriver webDriver;
    
    @BeforeTest
    public void openBrowser(){
    	System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		webDriver = new FirefoxDriver();
		webDriver.get("http://demosite.center/wordpress/wp-login.php");
		webDriver.manage().window().maximize();
			
    }
   
    @Test(dataProvider="wordpressdata")
	public void loginToWordPress(String userName,String password) throws InterruptedException{
    	webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		webDriver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys(userName);
		webDriver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys(password);
		webDriver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		System.out.println(webDriver.getTitle());
		Assert.assertTrue(webDriver.getTitle().contains("The ASD"),"Invalid user credentials... login fialed.");
		Thread.sleep(5000);	
	}
    
    @AfterTest
    public void tearDown(){
    	webDriver.quit();
    }
    
    @DataProvider(name="wordpressdata")
    public Object[][] data(){
       Object[][] dataarray = new Object[2][2];
    
       dataarray[0][0]="user1";
       dataarray[0][1]="user123";
       dataarray[1][0]="user2";
       dataarray[1][1]="user123";
    
    return dataarray;
    }
}
