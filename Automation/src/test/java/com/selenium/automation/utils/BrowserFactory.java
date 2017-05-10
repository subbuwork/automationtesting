/**
 * 
 */
package com.selenium.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author subbu
 *
 */
public class BrowserFactory {
	public static Logger logger = LoggerFactory.getLogger(BrowserFactory.class.getName());
   public static WebDriver driver;
	public static WebDriver launchBrowser(String browserName,String url){

		if(browserName.equalsIgnoreCase("chrome")){
			logger.info("Launching :: Chrome browser....");
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			//return driver;
		}else if(browserName.equalsIgnoreCase("ie")){
			logger.info("Launching :: IE browser....");
			System.setProperty("webdriver.ie.driver", "E:\\Softwares\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
			//return driver;
		}else if(browserName.equalsIgnoreCase("firefox")){
			logger.info("Launching :: FireFox browser....");
			System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver16.1.exe");
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		
	}
	public static void tearDownBrowser(WebDriver driver){
		logger.info("Closing browser...");
		driver.quit();
	}
	
	
	

}
