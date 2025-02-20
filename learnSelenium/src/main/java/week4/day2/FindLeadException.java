package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLeadException {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch & Handle browser window
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Logging in into Application
		driver.findElement(By.name("USERNAME")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//Navigating to Lead Page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Finding Existing Lead by FirstName
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("karthik");


		try {
			driver.findElement(By.xpath("(//span[text()='Lead List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])[1]/a")).click();
		} catch (StaleElementReferenceException e) {
			Thread.sleep(5000);		
			driver.findElement(By.xpath("(//span[text()='Lead List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])[1]/a")).click();
		}
	}
}
