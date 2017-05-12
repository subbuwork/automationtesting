package com.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTable {
  WebDriver webdriver;
  
  @BeforeTest
  public void lanunchBorwser()
  {
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  

  @Test
  public void dynamicTable() {
	 webdriver.get("http://money.rediff.com/gainers/bsc/dailygroupa?"); 
	 // No. Of cols
	 List<WebElement> cols = webdriver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
	  
	//No. of rows
	 List<WebElement> rows = webdriver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	System.out.println("Cols.:"+cols.size()+"::Rows::"+rows.size());
  }
	
@AfterTest
	  public void tearDownBorwser(){
		  webdriver.quit();
	  }
		
}
