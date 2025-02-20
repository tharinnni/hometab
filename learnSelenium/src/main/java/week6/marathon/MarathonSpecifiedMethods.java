package week6.marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MarathonSpecifiedMethods {
	String browserName="";
	RemoteWebDriver driver;
	WebDriverWait wait;
	Actions action;
	String excelFileName="";

	@Parameters({"url","username","password"})
	@BeforeMethod

	public void Setup(String url,String username,String password) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--disable-notifications");
			driver = new EdgeDriver();
		}
		action = new Actions(driver);
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'tooltip-trigger')]/following::div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider(name = "smoke")
	public String[][] feachData() throws IOException {
		String[][] values = SalesForceDataProvider.readData(excelFileName);
		return values;
	}
}
