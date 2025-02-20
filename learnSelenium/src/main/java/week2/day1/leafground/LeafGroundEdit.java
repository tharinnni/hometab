package week2.day1.leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("karthikyuva75@gmail.com");
		WebElement textAppend = driver.findElement(By.name("text"));
		textAppend.clear();
		textAppend.sendKeys("newvalues",Keys.TAB);
		//driver.findElement(by.)
		
		
	}

}
