package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonAutomationTesting {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://www.amazon.com");
		webDriver.manage().window().maximize();
		webDriver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Dell");
		webDriver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
	}

}
