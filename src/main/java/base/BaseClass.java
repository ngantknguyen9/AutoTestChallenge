package base;

import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.File;
public class BaseClass { 
	public WebDriver driver;

	@BeforeMethod
	public void runBeforeTest() {
		String OS = System.getProperty("os.name").toLowerCase();
		 if (OS.contains("mac")){
			 System.setProperty("webdriver.chrome.driver",
		                System.getProperty("user.dir") + File.separator + "driver/mac" + File.separator + "chromedriver");
		 }else {
			 System.setProperty("webdriver.chrome.driver",
				        System.getProperty("user.dir") + File.separator + "driver\\window" + File.separator + "chromedriver.exe");
		 }

	    driver = new ChromeDriver();
		driver.get("http://ktvn-test.s3-website.us-east-1.amazonaws.com/");
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
    public void closeBrowser() {
		driver.quit();
    }
}
