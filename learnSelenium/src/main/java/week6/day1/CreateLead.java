package week6.day1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	@Test
	public void leafLeadCreate() {
		//Setup WDM
		WebDriverManager.chromedriver().setup();
		//Create browser object and Launch URL 
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Login using username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();	
		//linktext to move to lead and create lead page
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		//Input Lead informations
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("qwerty pvt ltd");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthikeyan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramachandran");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kabir");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("S/W Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium learning 1st basic program");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("karthikyuva75@icloud.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9791920077");
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//Creating select class to select value in dropdown 
		Select stateSelect = new Select(stateDropdown);
		stateSelect.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		//Get window title to check we are in correct page. 
		String titleLeadResult = driver.getTitle();
		if(titleLeadResult.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Lead Created Successfully..!!");
		}
		driver.close();
		
	}

}
