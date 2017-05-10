
package com.selenium.pom.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author subbu
 *
 */
public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void validateLogin(String userName,String password){
		try {
			driver.findElement(By.id("user_login")).sendKeys(userName);
			driver.findElement(By.xpath("html/body/div[1]/form/p[2]/label/input")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.name("wp-submit")).click();
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void typeUserName(String userName){
		System.out.println("Inside type userName..");
		driver.findElement(uid).sendKeys(userName);
	}
	public void typePassword(String password){
		System.out.println("inside type password..");
		driver.findElement(pass).sendKeys(password);
	}
	
	public void clickSubmit(){
		System.out.println("Click method...");
		driver.findElement(submit).click();
	}*/

}
