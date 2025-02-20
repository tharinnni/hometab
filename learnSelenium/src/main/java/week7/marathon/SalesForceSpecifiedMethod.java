package week7.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesForceSpecifiedMethod {

	public ChromeDriver driver;
	public Shadow shadow;
	
	
	@BeforeMethod
	public void driverSetup() {

		//1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev64810.service-now.com/navpage.do"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		shadow = new Shadow(driver);
		shadow.setImplicitWait(10);

		//2. Login with valid credentials username and password 
		//   Create your own credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("310820@Atm");
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
