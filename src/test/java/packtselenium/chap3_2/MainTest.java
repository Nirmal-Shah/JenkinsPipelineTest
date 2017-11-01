package packtselenium.chap3_2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void verify(){
		driver.get("http://www.seleniumhq.org");
		String expectedTitle = "Selenium - Web Browser Automation";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"wrong title");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
  
}
