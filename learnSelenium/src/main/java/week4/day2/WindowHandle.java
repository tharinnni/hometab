package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("All windows are open now");
	}

}
