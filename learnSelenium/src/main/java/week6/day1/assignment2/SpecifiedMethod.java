package week6.day1.assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecifiedMethod {
	//Object Creation
	ChromeDriver driver;
	ChromeOptions options;
	WebDriverWait wait;
	Actions action;
	
	@BeforeMethod(groups ={"Account","Oppertunity"})
	public void browserSetup() {
		//Setup Web Driver Manager
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		action = new Actions(driver);
		//Launch SalesForce WebSite
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Input UserName and Password
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		//Click on Login
		driver.findElement(By.id("Login")).click();
	}
	//To Move View All in App Launcher
	@BeforeMethod(groups = {"Account","Oppertunity"})
	public void navigateToApp() {
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	//Method for Close the Browser
	@AfterMethod(alwaysRun = true, groups = {"Account","Oppertunity"})
	public void quiteBrowser() {
		driver.quit();
	}

}
