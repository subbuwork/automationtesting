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

public class DataDrivenTestCaseExcel {
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
    	ExcelReadingConfig excelReadingConfig = new ExcelReadingConfig("C:\\Users\\subbu\\automation\\SeleniumAutomation\\testdata\\Testdata.xlsx");
    	
    	Integer rowCount = excelReadingConfig.rowCount(0);
    	
    	Object[][] dataarray = new Object[rowCount][2];
       for(int i=0;i<rowCount;i++){
       dataarray[i][0]=excelReadingConfig.getData(0, i, 0);
       dataarray[i][1]=excelReadingConfig.getData(0, i, 1);
       }
    System.out.println("Data array:::"+dataarray.toString());
    return dataarray;
    }
}
