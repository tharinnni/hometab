package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		// WebDriverManager Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Shadow dom = new Shadow(driver);
		Actions actn = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Launch URL
		driver.get("https://login.salesforce.com");

		//Login into salesforce Application using login id and password
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();

		////click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//To handle Multiple Window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<String>(windowHandles);

		//Switching to new Tap
		driver.switchTo().window(switchWindow.get(1));

		//Handle SweetAlert
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		//To Click on Learning 
		WebElement findElementByXPath = dom.findElementByXPath("//span[text()='Learning']");
		findElementByXPath.click();	
		Thread.sleep(6000);

		//Mouse over on Learning on Trailhead
		WebElement mouseOverLT = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		actn.moveToElement(mouseOverLT).perform();

		//Moving to SF certification
		WebElement certificationSalesForce = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		certificationSalesForce.click();

		//Click Certification Administrator
		driver.findElement(By.linkText("Administrator")).click();

		////Take screenshot
		WebElement moveToJoinCM = driver.findElement(By.xpath("//div[text()='Join the community']"));
		actn.moveToElement(moveToJoinCM).perform();
		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("SalesAdmin.png");
		FileUtils.copyFile(source, dest);
		driver.quit();
	}

}
