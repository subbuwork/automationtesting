package com.selenium.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
    	//System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.google.com/");
    	driver.close();
    	driver.quit();
    }
}
