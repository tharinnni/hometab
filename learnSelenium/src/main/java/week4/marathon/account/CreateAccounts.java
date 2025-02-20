package week4.marathon.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
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
		Thread.sleep(3000);
		WebElement accountClick = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		driver.executeScript("arguments[0].click();", accountClick);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Account Name']/following::input)[1]")));
		WebElement sendName = driver.findElement(By.xpath("(//label[text()='Account Name']/following::input)[1]"));
		sendName.sendKeys("karthikeyan");
		driver.findElement(By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux slds-combobox__input-value\"])[3]")).click();
		driver.findElement(By.xpath("//span[@class=\"slds-media__body\"]/following::span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

}
