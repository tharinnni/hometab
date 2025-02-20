package week4.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDownSS {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();;
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		WebElement toBottom = driver.findElement(By.xpath("//span[text()=' 2022 ibibogroup All rights reserved']"));
		Actions scrollDown = new Actions(driver);
		scrollDown.scrollToElement(toBottom).perform();
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("Redbus.png");
		FileUtils.copyFile(source, dest);
		
	}

}
