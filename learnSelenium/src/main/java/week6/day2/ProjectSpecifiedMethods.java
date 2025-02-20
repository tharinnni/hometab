package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecifiedMethods {
	String excelFileName="";
	ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void setupAndLogin(String url,String username,String password) throws InterruptedException {
		//Setup WDM
		WebDriverManager.chromedriver().setup();
		//Create browser object and Launch URL 
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		//Login using username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.className("decorativeSubmit")).click();	
		//linktext to move to lead and create lead page
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void closeWebBrowser() {
		driver.quit();
	}

	@DataProvider(name = "smoke")
	public String[][] fechData() throws IOException {
		String[][] data = ReadExcelPOI.readExcel(excelFileName);
		return data;
	}
}
