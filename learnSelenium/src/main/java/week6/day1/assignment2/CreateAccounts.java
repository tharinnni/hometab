package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateAccounts extends SpecifiedMethod{
	@Test(priority = -1,invocationCount = 3 , timeOut = 7000,groups = "Account")
	//Method for Create New Account
	public void salesForceCreateAccounts() throws InterruptedException {
		System.out.println("Execution begine of CreateAccounts");
		//To Click On Sales in All Apps
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		//Click On Accounts
		WebElement accountClick = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		driver.executeScript("arguments[0].click();", accountClick);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Wait for Create account page to display and input Required Data
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Account Name']/following::input)[1]")));
		WebElement sendName = driver.findElement(By.xpath("(//label[text()='Account Name']/following::input)[1]"));
		sendName.sendKeys("karthikeyan");
		driver.findElement(By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux slds-combobox__input-value\"])[3]")).click();
		driver.findElement(By.xpath("//span[@class=\"slds-media__body\"]/following::span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("Closed Test Case CreateAccounts");
	}
	@Test(groups = "Account")
	//Logout functionality method
	public void logOut() {
		System.out.println("Logout Execution Started");
		driver.findElement(By.xpath("//button[@title=\"Close this window\"]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'profileTrigger')]")).click();
		driver.findElement(By.linkText("Log Out")).click();
		System.out.println("Logout Execution End");
	}

}
