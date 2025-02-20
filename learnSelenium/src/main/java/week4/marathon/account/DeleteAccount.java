package week4.marathon.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount {

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
		driver.findElement(By.xpath("(//label[contains(text(),'Search this list')]/following::div/input)[1]")).sendKeys("karthikeyan",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("((//td[@role=\"gridcell\"])[1]/following::a)[1]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,\"slds-button_icon-border-filled\")])[6]/lightning-primitive-icon")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@title=\"Delete\"]/span[text()='Delete']")).click();
		WebElement deletedAccInfo = driver.findElement(By.xpath("//span[contains(@class,\"toastMessage\")]"));
		System.out.println(deletedAccInfo.getText());
	}

}
