package week2.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement checkLogout = driver.findElement(By.className("decorativeSubmit")); 
		if(checkLogout.equals("Logout"));{
			System.out.println("Logged in Successfully");
		}
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("XYZ Pvt Ltd");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthikeyan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramachandran");
		WebElement dropdownSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropSelect=new Select(dropdownSource);
		dropSelect.selectByVisibleText("Public Relations");
		driver.findElement(By.className("smallSubmit")).click();
		String titleLead = driver.getTitle();
		if(titleLead.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Title verified You are on Correct Page..!!");
		}
	}

}
