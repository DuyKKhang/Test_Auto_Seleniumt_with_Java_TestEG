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
	String osName= System.getProperty("os.name");
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
	
//	@Test 
//	public void TC_Nested_text() {
//		// Mở trang
//		driver.get("https://automationfc.github.io/basic-form/");
//		
//		// Lấy ký tự in ra console
//		// sysout  + Ctrl space = System.out.println
//		System.out.println(driver.findElement(By.xpath("//h5[@id='nested']//span[@class='date']")).getText());
//		
//	}
	
	// Verify
	// Assert.assertTrue -> Kiểm tra 1 điều kiện đúng
	// Assert.assertFalse -> Kiểm tra 1 điều kiện sai
	// Assert.assertEquals -> Kiểm tra thực tế và mong đợi như nhau
	
	@Test 
	public void TC_01_Empty_Data() {
		// Mở trang
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");	
	}
	
	@Test
	public void TC_02_InvalidEmail(){
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action 1
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtFirstname']")).sendKeys("Normal man");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtEmail']")).sendKeys("Normal@sadasd@an");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCEmail']")).sendKeys("Normal@sadasd@an");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("0968565236");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		

		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	}
	
	@Test
	public void TC_03_Incorrect_Confirm_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action 1
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtFirstname']")).sendKeys("Normal man");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCEmail']")).sendKeys("Normal@sadasd@an");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("0968565236");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify

		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");

		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	}
	
	@Test
	public void TC_04_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action 1
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtFirstname']")).sendKeys("Normal man");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("0968565236");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify

		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	}
	
	@Test
	public void TC_05_Incorrect_Confirm_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action 1
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtFirstname']")).sendKeys("Normal man");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("123456123");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCPassword']")).sendKeys("123456125");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("0968565236");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		// Verify
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	}
	
	@Test
	public void TC_06_Invalid_Phone_number() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		// Action 1
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtFirstname']")).sendKeys("Normal man");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCEmail']")).sendKeys("Normalman@gmail.com");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtCPassword']")).sendKeys("12328");
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("096856");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");	
		
		// Action 2
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).clear();
		driver.findElement(By.xpath("//form[@id='frmLogin']//input[@id='txtPhone']")).sendKeys("1231");
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}