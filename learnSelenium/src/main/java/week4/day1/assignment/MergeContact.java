package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args){
		//WDM setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Login into Application
		driver.findElement(By.name("USERNAME")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//Moving to home screen
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		//Click on merge contact
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		//setup windows handler to switch to select contact
		Set<String> fromContact = driver.getWindowHandles();
		List<String> sourceContact = new ArrayList<String>(fromContact);
		String fromContactHandle = sourceContact.get(1);
		String toHome = sourceContact.get(0);
		driver.switchTo().window(fromContactHandle);
		driver.findElement(By.xpath("(//label[text()='First name:']/following::input)[1]")).sendKeys("karthik");
		driver.findElement(By.xpath("(//span[text()='Contact List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[1]")).click();
		driver.switchTo().window(toHome);
		//To select to contact 
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> toContact = new ArrayList<String>(windowHandles);
		String toContactHandle = toContact.get(1);
		String toHomecon = toContact.get(0);
		driver.switchTo().window(toContactHandle);
		driver.findElement(By.xpath("(//span[text()='Contact List']/following::div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[2]")).click();
		driver.switchTo().window(toHomecon);
		//Click on merge contact
		driver.findElement(By.className("buttonDangerous")).click();
		//To click ok on Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//To print title of the page
		System.out.println(driver.getTitle());
	}

}
