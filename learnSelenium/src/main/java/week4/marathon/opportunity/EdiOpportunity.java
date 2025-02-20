package week4.marathon.opportunity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdiOpportunity {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager and browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Login into Application
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		//Click on All application and moving to Sales
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Moving to Opportunities
		WebElement clickOpportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Opportunities']")));
		driver.executeScript("arguments[0].click();", clickOpportunities);
		//Search Opportunities and select 1st Result
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(),'Search this list')]/following::div)[1]")));
		driver.findElement(By.xpath("(//label[contains(text(),'Search this list')]/following::div/input)[1]")).sendKeys("karthikeyan",Keys.ENTER);
		Thread.sleep(900);
		driver.findElement(By.xpath("((//span[contains(@class,'slds-row-number')])[1]/following::a)[1]")).click();
		Thread.sleep(900);
		//Edit selected Result
		driver.findElement(By.xpath("(//button[contains(@class,\"slds-button_icon-border-filled\")])[5]/lightning-primitive-icon")).click();
		driver.findElement(By.xpath("//span[text()='Edit' and @class=\"slds-truncate\"]")).click();
		Thread.sleep(900);
		//Choose date
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[@name=\"CloseDate\"]")).click();
		driver.findElement(By.xpath("//span[text()='15' and @class='slds-day']")).click();
		//Select values in Stage
		driver.findElement(By.xpath("(//label[text()='Stage']/following::lightning-base-combobox[@class='slds-combobox_container'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Perception Analysis']")).click();
		//Select Delivery/Installation State
		WebElement moveToDescription = driver.findElement(By.xpath("//a[text()='Delivery Status']"));
		action.moveToElement(moveToDescription).perform();
		driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::lightning-base-combobox")).click();
		driver.findElement(By.xpath("//span[text()='In progress']")).click();
		Thread.sleep(30000);
		//Adding values in Description
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("SalesForce");
		//Save the Changes
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String changesUpdate = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println("Changes "+changesUpdate);
		
		driver.close();
	}

}
