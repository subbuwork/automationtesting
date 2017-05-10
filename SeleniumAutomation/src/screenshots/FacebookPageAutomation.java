package screenshots;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.selenium.utils.SeleniumUtil;


public class FacebookPageAutomation {
    
	WebDriver driver;
	
	//Launching browser..
	@BeforeMethod
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
	public void logInTestCase() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@2016");
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPage");
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		System.out.println("Title**********:"+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Facebook - Log In or Sign Up"),"Login success..");
		Thread.sleep(6000);
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginSucess");
	}
	
	@Test
	public void logOutTestCase() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@2016");
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPage");
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		//System.out.println("Title**********:"+driver.getTitle());
		Select select = new Select(driver.findElement(By.xpath(".//*[@id='userNavigationLabel']")));
		select.selectByVisibleText("Log Out");
		Assert.assertTrue(driver.getTitle().contains("Facebook - Log In or Sign Up"),"Login success..");
		Thread.sleep(7000);
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginSucess");
	}
	
	@Test
	public void invalidFiledsTestCase() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@2017");
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPage");
		driver.findElement(By.xpath(".//*[@id='u_0_q']nn")).click();
		System.out.println("Title##########:"+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Fail"),"Invalid field names.. login failed");
		Thread.sleep(6000);
		
	}
	
	
	@Test
	public void loginFailTestCase() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("subbu.varsith1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("chitti@2017");
		//SeleniumUtil.takeScreenShot(driver,"FacebookLoginPage");
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
		System.out.println("Title##########:"+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Facebook - Log In or Sign Up"),"Invalid credentials.. login failed");
		Thread.sleep(6000);
		
	}
	
	//Closing browser... before closing capturing screen shot of result..
	@AfterMethod
	public void driverTearDown(ITestResult iTestResult){
		if(ITestResult.FAILURE == iTestResult.getStatus()){
			System.out.println(iTestResult.getName()+"::Test failed.... status Code::"+iTestResult.getStatus());
			SeleniumUtil.takeScreenShot(driver,iTestResult.getName());
		}
		if(ITestResult.SUCCESS == iTestResult.getStatus()){
			System.out.println(iTestResult.getName()+":::::Test success...status Code::"+iTestResult.getStatus());
			SeleniumUtil.takeScreenShot(driver,iTestResult.getName());
		}
		driver.quit();
	}
	
}
