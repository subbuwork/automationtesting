package com.apache.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLoginAutomationTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://www.facebook.com");
		webDriver.manage().window().maximize();
		webDriver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		webDriver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@2016");
		webDriver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		
		Select select = new Select(webDriver.findElement(By.xpath(".//*[@id='userNavigationLabel']")));
		select.selectByValue("");
		
		//webDriver.findElement(By.xpath(".//*[@id='userNavigationLabel']")).click();
		webDriver.findElement(By.xpath(".//*[@id='BLUE_BAR_ID_DO_NOT_USE']/div/div/div[1]/div/div/ul/li[16]/a/span/span")).click();
		
		
	}

}
