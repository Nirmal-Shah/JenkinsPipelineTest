package packtselenium.chap3_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDocumentationTest_01 {

	public static void main(String arg[]){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumhq.org");
		driver.quit();
	}
	
}
