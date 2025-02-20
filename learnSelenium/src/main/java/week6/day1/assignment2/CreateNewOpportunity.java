package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateNewOpportunity extends SpecifiedMethod{

	@Test(enabled = false,groups = "Account")
	public void main() throws InterruptedException {
		System.out.println("CreateNewOpportunity Eexcution Started");
		//Wait for Sales to display and click on Sales
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//To Click on Opportunities
		WebElement clickOpportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Opportunities']")));
		driver.executeScript("arguments[0].click();", clickOpportunities);
		Thread.sleep(2000);
		//Click on new Opportunities to create
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);
		//Input Opportunities
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']/following::input)[1]")).sendKeys("Salesforce Automation by Karthikeyan");
		driver.findElement(By.xpath("//input[@name=\"CloseDate\"]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("(//label[text()='Stage']/following::div[contains(@class,'slds-combobox')])[1]")).click();
		driver.findElement(By.xpath("//span[@class=\"slds-media__body\"]/following::span[text()='Needs Analysis']")).click();
		//Click on Save to Create Opportunities
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("CreateNewOpportunity Eexcution Completed");
	}

}
