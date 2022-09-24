package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Stype {

	public static void main(String[] args) {
		// I - Kiểu dử liệu nguyên thủy
		// byte
		byte bSo= 127;
		
		// short
		short sSo = 32000;
		
		// int 
		int iSo = 499232299;
		
		// long
		long lSo = 832946;
				
		// số thực
		// float
		float fNumeber = 16.3f;
		
		// double
		double dNumber = 35.6d;
		
		// Logic
		boolean Status =true;
		
		// ký tự
		char cKytu = 'a';
		
		// II-  Kiểu dữ liệu tham chiếu (Refence)
		// Ctrl + Shift + O: Tự động import
		// class
		FirefoxDriver driver = new FirefoxDriver(); 
		
		// Interface
		WebElement firtName;
		
		// String
		String sName = "Automation Test";
		// Khi thấy "" thì là kiểu chuổi ký tự
		
		// Object
		Object apple;
		
		//Array
		String[] student = {"A","S","D"}; // đây là mãng ký tự
		
		// Collection: List/ Set/ Quecue
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector(""));
				
		// Map
		Map<String,Integer> students = new HashMap<String, Integer>();
	}

}
