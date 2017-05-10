/**
 * 
 */
package com.seleniu.java.pom.facebook.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.java.selenium.utils.BrowserFactory;
import com.selenium.automation.excel.ExcelReadingConfig;
import com.selenium.pom.facebook.LoginPage;

/**
 * @author subbu
 *
 */
public class VerifyLoginPage {
	
	@Test
	public void verifyLogin() throws InterruptedException{
		try {
			WebDriver driver = BrowserFactory.launchBrowser("chrome","http://demosite.center/wordpress/wp-login.php");
			//driver.get("");
			//Fetching input data from excel file
			ExcelReadingConfig excelConfig = new ExcelReadingConfig("C:\\Users\\subbu\\Desktop\\Testdata.xlsx",0);
			Integer rowCount = excelConfig.numberOfRows();
			
			for(int i=0;i<rowCount;i++){
			LoginPage loginPage = new LoginPage(driver);
			loginPage.validateLogin(excelConfig.getData(0,0),excelConfig.getData(0,1));
			
			//loginPage.clickSubmit();
			//Thread.sleep(8000);
			BrowserFactory.tearDownBrowser(driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
