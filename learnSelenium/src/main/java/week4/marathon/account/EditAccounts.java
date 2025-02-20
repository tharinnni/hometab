package week4.marathon.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditAccounts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
 		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement moveToAccount  = driver.findElement(By.xpath("//p[text()='App Launcher']"));
		action.moveToElement(moveToAccount).perform();
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		driver.findElement(By.xpath("(//label[contains(text(),'Search this list')]/following::div/input)[1]")).sendKeys("karthik",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@role=\"gridcell\"]/following::a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=\"Show more actions\"]/parent::button")).click();
		driver.findElement(By.xpath("//span[text()=\"Edit\"]")).click();
		WebElement webElementPhone = driver.findElement(By.xpath("(//label[text()='Phone']/following::input[@class=\"slds-input\"])[1]"));
		webElementPhone.clear();
		webElementPhone.sendKeys("9791920088");
		driver.findElement(By.xpath("//label[text()=\"Type\"]/following::span[@class=\"slds-truncate\"][1]")).click();
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//legend[text()='Billing Address']/following::textarea[@class=\"slds-textarea\"])[1]")).sendKeys("No.7,Chrompet,Chennai-44.");
		driver.findElement(By.xpath("(//legend[text()='Shipping Address']/following::textarea[@class=\"slds-textarea\"])[1]")).sendKeys("No.7,11th Ave,Ashok Nagar,Chennai-83.");
		Thread.sleep(2000);
		WebElement moveToUp = driver.findElement(By.xpath("//label[text()='Description']"));
		action.moveToElement(moveToUp).perform();
		driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::span[@class=\"slds-truncate\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		driver.findElement(By.xpath("(//label[text()='SLA']/following::span[@class=\"slds-truncate\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
		driver.findElement(By.xpath("//button[@name=\"SaveEdit\"]")).click();
		WebElement printUpdatedPhone = driver.findElement(By.xpath("(//p[text()='Phone']/following::a)[1]"));
		System.out.println("Updated Mobile number is: "+printUpdatedPhone.getText());
	}

}
