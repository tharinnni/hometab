package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditAccounts extends SpecifiedMethod{
	@Test(groups = "Account")
	public void salesForceEditAccounts() throws InterruptedException {
		System.out.println("EditAccounts Eexcution Started");
		//Move to Account and click on Account 
		WebElement moveToAccount  = driver.findElement(By.xpath("//p[text()='App Launcher']"));
		action.moveToElement(moveToAccount).perform();
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		//To search account which is want to edit
		driver.findElement(By.xpath("(//label[contains(text(),'Search this list')]/following::div/input)[1]")).sendKeys("karthik",Keys.ENTER);
		Thread.sleep(2000);
		//Select first account data from the search result
		driver.findElement(By.xpath("(//td[@role=\"gridcell\"]/following::a)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=\"Show more actions\"]/parent::button")).click();
		//Editing the Selected Account
		driver.findElement(By.xpath("//span[text()=\"Edit\"]")).click();
		//Input account infromation which is needs to update
		WebElement webElementPhone = driver.findElement(By.xpath("(//label[text()='Phone']/following::input[@class=\"slds-input\"])[1]"));
		webElementPhone.clear();
		webElementPhone.sendKeys("9791920088");
		driver.findElement(By.xpath("//label[text()=\"Type\"]/following::span[@class=\"slds-truncate\"][1]")).click();
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//legend[text()='Billing Address']/following::textarea[@class=\"slds-textarea\"])[1]")).sendKeys("No.7,Chrompet,Chennai-44.");
		driver.findElement(By.xpath("(//legend[text()='Shipping Address']/following::textarea[@class=\"slds-textarea\"])[1]")).sendKeys("No.7,11th Ave,Ashok Nagar,Chennai-83.");
		Thread.sleep(2000);
		WebElement moveToUp = driver.findElement(By.xpath("//label[text()='Description']"));
		action.moveToElement(moveToUp).perform();
		driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::span[@class=\"slds-truncate\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		driver.findElement(By.xpath("(//label[text()='SLA']/following::span[@class=\"slds-truncate\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
		//Save the Changes
		driver.findElement(By.xpath("//button[@name=\"SaveEdit\"]")).click();
		System.out.println("EditAccounts Eexcution Completed");
	}

}
