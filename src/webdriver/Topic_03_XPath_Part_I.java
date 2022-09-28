package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

//	@Test
//	public void TC_01_() {
//		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
//		
//		// Click vào account
//		driver.findElement(By.xpath("//div[@class='fooder']//a[@title='My Account']")).click();
//		// cơ chế selenium luôn thao tác với eleent đầu tiên
//	}
	
	@Test 
	public void TC_Nested_text() {
		// Mở trang
		driver.get("https://automationfc.github.io/basic-form/");
		
		// Lấy ký tự in ra console
		// sysout  + Ctrl space = System.out.println
		System.out.println(driver.findElement(By.xpath("//h5[@id='nested']//span[@class='date']")).getText());
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}