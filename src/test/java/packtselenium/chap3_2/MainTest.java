package packtselenium.chap3_2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		ChromeDriverService service;
		File file = new File(System.getProperty("user.dir")+"//resources//drivers//chromedriver");
		file.setExecutable(true);
		file.setReadable(true);
		file.setWritable(true);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//drivers//chromedriver");
		service = new ChromeDriverService.Builder()
                .usingDriverExecutable(file)
                .usingAnyFreePort()
                .build();
		try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		driver.manage().window().maximize();
	}
	
	@Test
	public void verify(){
		driver.get("http://www.seleniumhq.org/");
		String expectedTitle = "Selenium - Web Browser Automation";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"wrong title");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
  
}