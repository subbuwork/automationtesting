package screenshots;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.selenium.utils.SeleniumUtil;


public class screenshotforFailedTest {
    
	WebDriver driver;
	
	//Launching browser..
	@BeforeTest
	public void openBrowser(){
		System.setProperty("webdriver.gecko.driver", "E:\\Softwares\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Selenium\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPageBeforeEnterData");
		
	}

	@Test
	public void takeScreenshot() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@20016");
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPage");
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		Thread.sleep(6000);
		
		
	}
	
	//Closing browser...
	@AfterTest
	public void driverTearDown(ITestResult result){
		if(ITestResult.FAILURE == result.getStatus()){
			SeleniumUtil.takeScreenShot(driver,result.getName());
		}
		
		driver.quit();
	}
	
}
