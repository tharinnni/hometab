package week4.marathon.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySorting {
	
	
	public static void main(String[] args) throws InterruptedException {
		//Webdriver Setup and disable notification
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		//Launch browser and Login into Application
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		//Opening App Launcher and click on Sales
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		driver.findElement(By.xpath("//p[text()=\"Sales\"]")).click();
		//Opening Accounts Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()=\"Accounts\"])[1]")));
		WebElement moveToAccounts = driver.findElement(By.xpath("(//span[text()=\"Accounts\"])[1]"));
		driver.executeScript("arguments[0].click()", moveToAccounts);
		//Sorting Name in Asc
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Account Name']")));
		WebElement sortInAsc = driver.findElement(By.xpath("//span[@title='Account Name']"));
		action.moveToElement(sortInAsc).perform();
		action.click().perform();
		
	}

}
