
package com.selenium.pom.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author subbu
 *
 */
public class LoginPage {
	WebDriver driver;
	By uid = By.id("user_login");
	By pass = By.xpath("html/body/div[1]/form/p[2]/label/input");
	By submit = By.name("wp-submit");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void typeUserName(String userName){
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
	}

}
