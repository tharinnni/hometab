package week4.marathon.opportunity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOpportunity {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement clickOpportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Opportunities']")));
		driver.executeScript("arguments[0].click();", clickOpportunities);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']/following::input)[1]")).sendKeys("Salesforce Automation by Karthikeyan");
		driver.findElement(By.xpath("//input[@name=\"CloseDate\"]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("(//label[text()='Stage']/following::div[contains(@class,'slds-combobox')])[1]")).click();
		driver.findElement(By.xpath("//span[@class=\"slds-media__body\"]/following::span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.close();
	}

}
