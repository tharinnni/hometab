package week6.day1.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecifiedMethods{
	@Test
	public void leafTapEditLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("((//label[text()=\"First name:\"])[3]/following::input)[1]")).sendKeys("karthikeyan");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Selection First Search Result
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"])[1]/a")).click();
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
