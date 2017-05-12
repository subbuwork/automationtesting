package com.selenium.automation.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.selenium.automation.utils.ActionsUtils;
import com.selenium.automation.utils.BrowserFactory;

public class DateTimePicker {
	WebDriver webdriver;
  @Test
  public void dateTime() throws Exception {
	  webdriver = BrowserFactory.launchBrowser("firefox","http://www.redbus.in");
	  Thread.sleep(1000);;
	  webdriver.findElement(By.xpath("//input[@id='src']")).sendKeys("Ongole");
	  webdriver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Chennai");
	  // Onward calendar date select
	  webdriver.findElement(By.xpath("//*[@id='onward_cal']")).click();
	  Thread.sleep(2000);
	
	  //Next and previous operations  logic
	  // webdriver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[@class='next']")).click();
	 // Thread.sleep(2000); 
	 // webdriver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[@class='prev']")).click();
	 
	  // Elements in the onward date calendar
	  List<WebElement> elements  = webdriver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
	  Integer size = elements.size();
	  for(int i =0; i<size;i++){
		String date = elements.get(i).getText();
		if(date.equalsIgnoreCase("30")){
			Thread.sleep(1500);
			ActionsUtils.mouseOverOperation(webdriver, elements.get(i));
			Thread.sleep(1500);
			elements.get(i).click();
			
		}
	}
	  
	//Return date calendar.  
	 webdriver.findElement(By.xpath(".//*[@id='return_cal']")).click();;
	 Thread.sleep(2000);
	 webdriver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr/td[@class='next']")).click();
	 Thread.sleep(1000); 
	 List<WebElement> returnCalEle =webdriver.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr/td"));
	 Integer calSize = returnCalEle.size();
	 for(int i = 0; i<calSize; i++){
		String returnDate = returnCalEle.get(i).getText();
		if(returnDate.equalsIgnoreCase("5")){
			ActionsUtils.mouseOverOperation(webdriver, returnCalEle.get(i));
			Thread.sleep(1000);
			returnCalEle.get(i).click();
		}
	 }
	  System.out.println("Befor searh...");
	 webdriver.findElement(By.xpath("//*[@id='search_btn']")).click(); 
	//Thread.sleep(2000);
	//BrowserFactory.tearDownBrowser(webdriver);
	  
	  
	  
	 
  }
}
