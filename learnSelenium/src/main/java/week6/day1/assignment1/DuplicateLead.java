package week6.day1.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DuplicateLead extends ProjectSpecifiedMethods{
	@Test
	public void leafTapDuplicateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		//Input Lead informations
		WebElement companyName =driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("qwerty pvt ltd");
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Karthikeyan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramachandran");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kabir");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("S/W Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium learning 1st basic program");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("karthikyuva75@icloud.com");
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//Creating select class to select value in dropdown 
		Select stateSelect = new Select(stateDropdown);
		stateSelect.selectByVisibleText("New York");
		WebElement createLead = driver.findElement(By.className("smallSubmit"));
		createLead.click();
		//Get window title to check we are in correct page. 
		String titleLeadResult = driver.getTitle();
		if(titleLeadResult.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Lead Created Successfully..!!");
		}
		//To edit the duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		//clear Existing text in created Lead
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		//Sending new values to lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("KR infotech");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Krithvik Ramdutya");
		//Create lead after modification
		driver.findElement(By.className("smallSubmit")).click();
		if(titleLeadResult.equals("View Lead | opentaps CRM"))
		{
			System.out.println("duplicate Lead Updated  Successfully..!!");
		}
	}
}
