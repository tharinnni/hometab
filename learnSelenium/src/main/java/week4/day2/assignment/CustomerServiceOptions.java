package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) throws InterruptedException {
		// WebDriverManager Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Shadow dom = new Shadow(driver);
		Actions actn = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Launch URL
		driver.get("https://login.salesforce.com");
		
		//Login to SF login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//To handle new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchWindow.get(1));
		
		//Handling Sweet Alert
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(3000);
		
		//To click on Product
		WebElement moveToProducts = dom.findElementByXPath("//span[text()='Products']");
		moveToProducts.click();
		Thread.sleep(3000);
		
		//Mousehover on Service 
		WebElement moveToService = dom.findElementByXPath("//span[text()='Service']");
		actn.moveToElement(moveToService).perform();
		
		//Click on Customer service
		WebElement moveToCustService = dom.findElementByXPath("//a[text()='Customer Service']");
		moveToCustService.click();
		
		//To print available service 
		List<WebElement> listOfServices = driver.findElements(By.xpath("//a[text()='Customer Service']/following::ul[@class=\"page-list page-list-level-2\"]/li"));
		for (WebElement availableSerivceList : listOfServices) {
			System.out.println(availableSerivceList.getText());
			
		}
		
		//To verify the Title of the Page
		System.out.println(driver.getTitle());
	}

}
