package week7.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident {

	public static void main(String[] args) throws InterruptedException {

		//1. Launch ServiceNow application
		WebDriverManager.edgedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://dev64810.service-now.com/navpage.do"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//2. Login with valid credentials username and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("310820@Atm");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		
		//3. Click All
		Thread.sleep(3000);
		shadow.findElementByXPath("//div[text()='All']").click();
	    
	    //4.Click  Incidents in Filter navigator
	   	shadow.findElementByXPath("//span[text()='Incidents']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("(//th[@name='number']/following::td[@class=\"vt\"]/a)[1]")).click();
//		String deletedIncidentNumber = driver.findElement(By.xpath("//span[text()='Number']/following::input[@id='incident.number']")).getText();
//		System.out.println(deletedIncidentNumber);
		
		//5. Delete the incident
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Delete'])[1]")));
		shadow.findElementByXPath("(//button[text()='Delete'])[1]").click();
		driver.findElement(By.id("ok_button")).click();
		
		//6. Verify the deleted incident
		
	}

}