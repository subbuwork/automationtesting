package SeleniumUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtil {
	
	
	public static void takeScreenShot(WebDriver driver, String screenshotName){
		try {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File screenShot = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot,new File("./screenshots/"+screenshotName+".jpeg"));
			System.out.println("Screen shot taken...");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
