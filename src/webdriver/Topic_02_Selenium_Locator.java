package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// mở trang
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_Id() {
			driver.findElement(By.id("FirstName")).sendKeys("Khang");
		}

	@Test
	public void TC_02_Class() {
		// Mở web
			driver.get("https://demo.nopcommerce.com/search");
			// tìm class
			driver.findElement(By.className("search-text")).sendKeys("latop");		
		}

	@Test
	public void TC_03_Name() {
		// click vào text box
			driver.findElement(By.name("advs")).click();		
		}
	@Test
	public void TC_04_Tagname() {
		// tìm ra có bao nhiêu thẻ trên màn hình hiện tại
			System.out.println(driver.findElements(By.tagName("input")).size());		
		}
	@Test
	public void TC_05_LinkText() {
			// Click vào đường link Addresses (LinkText là tuyệt đối)
			driver.findElement(By.linkText("Addresses")).click();
		}
	@Test
	public void TC_06_PartialLinkText() {
			// Click vào đường link (Tương đố. Châm hơn LinkText)
		driver.findElement(By.partialLinkText("vendor account")).click();
		}
	@Test
	public void TC_07_Css() {
			// Nhiều cách viết với CSS
		driver.get("https://demo.nopcommerce.com/register");
		// 1.
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Duykhang")	;
		// 2.
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Nguyen");
		// 3. 
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("khduy");
		}
	@Test
	public void TC_08_XPath() {
		 // Nhiều cách viết với CSS
			// Mở web
			driver.get("https://demo.nopcommerce.com/register");
			// 1.
			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Duykhangsss")	;
			// 2.
			driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nguyendd");
			// 3. 
			driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("khđduy");
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}