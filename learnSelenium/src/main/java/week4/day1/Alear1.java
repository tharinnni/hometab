package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alear1 {
	
	public ChromeDriver driver; 

	@Test
	public void testIgnore() {
	//	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/lab");
		
		String pageTitle = driver.getTitle();
		
		System.out.println(isPageReachable());
		
	}
	
	public boolean isPageReachable() {
		boolean status = false;
		String titleofWebPage = driver.getTitle();
		
		if (titleofWebPage.isEmpty() || titleofWebPage == null) {
		  status = false;
		}else {
			status = true;
		}
		
		return status;
		 
		
			}

}
