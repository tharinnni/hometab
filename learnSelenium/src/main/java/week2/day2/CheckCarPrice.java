package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckCarPrice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zoomcar.com/in/bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Pick Up City, Airport, Address or Hotel')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h3[text()='Suggested Pick Up Locations'])/following::div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"field-date start-time\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='title']/following::td)[31]")).click();
		driver.findElement(By.xpath("(//div[@class='title']/following::td)[31]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
		Thread.sleep(60000);
		WebElement carRentElement = driver.findElement(By.xpath("//h3[text()='Maruti Swift Dzire']/following::div[@class='price-book-ctr']/div/div"));
		String CarRent=carRentElement.getText();
		System.out.println(CarRent);
		
		
	}

}
