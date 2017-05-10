/**
 * 
 */
package com.java.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author subbu
 *
 */
public class ActionsUtils {
	
	public static void mouseOverOperation(WebDriver webDriver, WebElement element){
		System.out.println("mouseOverOperation web element::");
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element).perform();
	}

}
