package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecifiedMethods {

	ChromeDriver driver;
	@BeforeMethod
	public void setupAndLogin() {
		//Setup WDM
		WebDriverManager.chromedriver().setup();
		//Create browser object and Launch URL 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Login using username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();	
		//linktext to move to lead and create lead page
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void closeWebBrowser() {
		driver.quit();
	}

}
