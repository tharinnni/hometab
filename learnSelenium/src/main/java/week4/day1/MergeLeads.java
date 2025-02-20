package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads {

	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.name("USERNAME")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		
		driver.findElement(By.xpath("(//span[text()='From Lead']/following::img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handleFromLead = new ArrayList<String>(windowHandles);
		String fromLead = handleFromLead.get(1);
		String backToHome = handleFromLead.get(0);
		driver.switchTo().window(fromLead);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//label[text()='First name:']/following::input[@name='firstName']")).sendKeys("karthik");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//span[text()='Lead List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])[1]/a")).click();
		driver.switchTo().window(backToHome);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//span[text()='To Lead']/following::img)[1]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> handleToLead = new ArrayList<String>(windowHandles2);
		String toLead = handleToLead.get(1);
		String backToHome2 = handleToLead.get(0);
		driver.switchTo().window(toLead);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//label[text()='First name:']/following::input[@name='firstName']")).sendKeys("karthik");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//span[text()='Lead List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])[2]/a")).click();
		driver.switchTo().window(backToHome2);
		
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
