package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

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

		//Login into SF Application
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();

		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//To handle new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(switchWindow.get(1));

		//Handle SweetAlert
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		//To Click on Learning option
		WebElement findElementByXPath = dom.findElementByXPath("//span[text()='Learning']");
		findElementByXPath.click();	
		Thread.sleep(6000);

		//Mouseover on Learning on Trailhead
		WebElement mouseOverLT = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		actn.moveToElement(mouseOverLT).perform();

		//Click on SF certificate 
		WebElement certificationSalesForce = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		certificationSalesForce.click();

		//Select Role as Salesforce Architect
		driver.findElement(By.xpath("(//div[text()=\"Salesforce\"])[2]")).click();
		WebElement moveTo = driver.findElement(By.xpath("//h2[@class=\"cert-site_title slds-p-vertical--large\"]"));
		actn.moveToElement(moveTo).perform();

		//Get Summary of SF Architect
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("architectcertification");
		FileUtils.copyFile(source, dest);

		//To get list of available Architect Certifications
		List<WebElement> listOfCertificate = driver.findElements(By.xpath("//div[@class=\"credentials-card_title\"]/a"));
		System.out.println("List of Available Architect Certifications");
		for (WebElement webElementCertificate : listOfCertificate) {
			System.out.println(webElementCertificate.getText());
		}

		//Click on Application Architect 
		driver.findElement(By.xpath("//div[@class=\"credentials-card_title\"]/a[text()='Application Architect']")).click();
		System.out.println("List of Available Application Architect Certifications");

		//List of available Certifications 
		List<WebElement> listApplicationArchitect = driver.findElements(By.xpath("//div[@class=\"credentials-card_title\"]/a"));
		for (WebElement lstAppArch : listApplicationArchitect) {
			System.out.println(lstAppArch.getText());

		}
		driver.quit();
	}

}
