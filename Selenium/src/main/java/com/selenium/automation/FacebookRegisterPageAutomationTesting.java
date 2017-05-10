package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegisterPageAutomationTesting {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		WebDriver webDriver  = new FirefoxDriver();
		webDriver.get("http://www.facebook.com/");
		webDriver.manage().window().maximize();
		webDriver.findElement(By.xpath(".//*[@id='u_0_1']")).sendKeys("Selenium");
		webDriver.findElement(By.xpath(".//*[@id='u_0_3']")).sendKeys("Testing");
		webDriver.findElement(By.xpath(".//*[@id='u_0_6']")).sendKeys("9805858460");
		//webDriver.findElement(By.xpath("")).sendKeys(" ");
        
		//Selecting values from drop down box  in the apge...
		Select sel1 = new Select(webDriver.findElement(By.xpath(".//*[@id='month']")));
		sel1.selectByVisibleText("Jul");
		Select sel2 = new Select(webDriver.findElement(By.xpath(".//*[@id='day']")));
		sel2.selectByValue("11");
		Select sel3 = new Select(webDriver.findElement(By.xpath(".//*[@id='year']")));
		sel3.selectByValue("1984");
		
		//Clicking radio button in the page...
		webDriver.findElement(By.xpath(".//*[@id='u_0_j']/span[2]")).click();
		
		//Clicking submit button in the page..
		webDriver.findElement(By.xpath(".//*[@id='u_0_l']")).click();
		
		//Clicking links in the page..
		webDriver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
		
		//Clicking back button in the page..
		webDriver.navigate().back();
		//closing browser...
		webDriver.quit();
	}

}
