package week4.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividuals {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement induvidualClick = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Thread.sleep(3000);
		action.scrollToElement(induvidualClick).perform();
		induvidualClick.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		Thread.sleep(3000);
		WebElement newIndividual = driver.findElement(By.xpath("//span[text()=\"New Individual\"]"));
		driver.executeScript("arguments[0].click();", newIndividual);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder=\"Last Name\"]")));
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"toastMessage slds-text-heading--small forceActionsText\"]")));
		String successMessage = driver.findElement(By.xpath("//span[@class=\"toastMessage slds-text-heading--small forceActionsText\"]")).getText();
		System.out.println(successMessage);
		driver.close();
	}

}
