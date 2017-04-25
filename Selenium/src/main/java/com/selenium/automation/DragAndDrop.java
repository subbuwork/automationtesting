package com.selenium.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://www.keenthemes.com/preview/metronic/templates/admin/ui_tree.html");
		webDriver.manage().window().maximize();
		WebElement from =webDriver.findElement(By.xpath(".//*[@id='j3_7_anchor']"));
		WebElement to = webDriver.findElement(By.xpath(".//*[@id='j3_1_anchor']"));
		
		Actions builder = new Actions(webDriver);
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		dragAndDrop.perform();
		webDriver.close();
	}
}
