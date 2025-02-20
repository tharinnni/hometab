package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {
	
	public static void main(String[] args) {
		//WebDriverManager Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch Browser
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Edit.html");
		//Input mail id to inputbox
		driver.findElement(By.id("email")).sendKeys("karthikyuva75@gmail.com");
		//Clear exisiting values and append a new value
		WebElement textAppend = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		textAppend.clear();
		textAppend.sendKeys("newvalues",Keys.TAB);
		//Clearing existing Value
		driver.findElement(By.xpath("//label[text()='Clear the text']/following::input")).clear();
		//Check the inputbox is editable
		boolean isEdiable = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input")).isEnabled();
		if(isEdiable) {
			System.out.println("Input box is editable");
		}else
		{
			System.out.println("Input box is Grayedout");
		}
		
	}

}
