package week6.day1.oops;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditLead extends UtilityFunctions{
	@Test
	public void leafEditLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("((//label[text()=\"First name:\"])[3]/following::input)[1]")).sendKeys("babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Selection First Search Result
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[text()='Lead ID']/following::div[contains(@class,'x-grid3-row')]/following::a)[1]")).click();
		//Verify the Title of the Page
		String editPageTitle = driver.getTitle();
		if(editPageTitle.equals("View Lead | opentaps CRM"))
		{
		System.out.println("Title of the page Verified!!");
		}else
		{
			System.out.println("You are in Wrong Page!!");
		}
		//Editing Result To Update The Company Name
		driver.findElement(By.linkText("Edit")).click();
		//Create a String Variable To Store The Company Name To Send And Verify
		String updateCompanyName = "ABC Pvt Ltd";
		WebElement editcompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		editcompanyName.clear();
		editcompanyName.sendKeys(updateCompanyName);
		driver.findElement(By.xpath("(//input[@name=\"submitButton\"])[1]")).click();
		//To verify the update company name
		String newCompanyName = driver.findElement(By.xpath("(//span[text()='Company Name']/following::span)[1]")).getText();
		String[] splitCompanyName=newCompanyName.split("\\(");
		if(splitCompanyName[0].trim().equals(updateCompanyName)) {
		System.out.println("New Company Name Updated Successfully!!"); 
		}
		else {
			System.out.println("Comapny Name update Failed!!");
		}
	}

}
