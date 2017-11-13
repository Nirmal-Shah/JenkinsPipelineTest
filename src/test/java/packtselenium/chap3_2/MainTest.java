package packtselenium.chap3_2;

import java.io.File;

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
		File file = new File(System.getProperty("user.dir")+"//resources//drivers//chromedriver");
		file.setExecutable(true);
		file.setReadable(true);
		file.setWritable(true);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//drivers//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void verify(){
		driver.get("http://localhost:8070/SimpleWebApp/");
		String expectedTitle = "Selenium - Web Browser Automation";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"wrong title");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
  
}