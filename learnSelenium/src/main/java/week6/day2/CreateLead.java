package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecifiedMethods {
	
	@BeforeTest
	public void setupExcel() {
		
		excelFileName = "CreateLead";	
	}

	/*
	 * @DataProvider(name = "smoke") public String[][] fechData() throws IOException
	 * { <----------dataprovider hardcoded value---------------> String[][] data =
	 * new String[2][5];
	 * 
	 * data[0][0] = "TCS"; data[0][1] = "Karthikeyan"; data[0][2] = "Ramachandran";
	 * data[0][3] = "Kabir"; data[0][4] = "S/W Testing";
	 * 
	 * data[1][0] = "Amazon"; data[1][1] = "Tharini"; data[1][2] = "Karthikeyan";
	 * data[1][3] = "Tharu"; data[1][4] = "S/W Testing";
	 * 
	 * String[][] data = ReadExcelPOI.readExcel("CreateLead"); return data; }
	 */

	@Test(dataProvider = "smoke")
	public void leafTapCreateLead(String companyName, String firstName, String lastName) {
		// Move to Create New Lead
		driver.findElement(By.linkText("Create Lead")).click();
		// Input Lead informations
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		// driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(firstNameLocal);
		// driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(departmentName);
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium learning 1st basic program");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("karthikyuva75@icloud.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9791920077");
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		// Creating select class to select value in dropdown
		Select stateSelect = new Select(stateDropdown);
		stateSelect.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		// Get window title to check we are in correct page.
		String titleLeadResult = driver.getTitle();
		if (titleLeadResult.equals("View Lead | opentaps CRM")) {
			System.out.println("Lead Created Successfully..!!");
		}

		if (firstName.equals("Karthikeyan")) {
			System.out.println("1st itration from data set 1");
		} else {
			System.out.println("2nd itration from data set 2");
		}

	}

}
