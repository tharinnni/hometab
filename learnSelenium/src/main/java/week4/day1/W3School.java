package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3School {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alertW = driver.switchTo().alert();
		alertW.dismiss();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
	}

}
