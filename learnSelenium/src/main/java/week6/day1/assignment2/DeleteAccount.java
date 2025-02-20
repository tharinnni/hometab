package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteAccount extends SpecifiedMethod {
	@Test(invocationCount = 2, invocationTimeOut =18000,groups = "Account" )
	//Delete Account Method
	public void salesForceDeleteAccount() throws InterruptedException {
		System.out.println("DeleteAccount Eexcution Started");
		//Click on Accounts
		WebElement moveToAccount  = driver.findElement(By.xpath("//p[text()='App Launcher']"));
		action.moveToElement(moveToAccount).perform();
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		//Search Account by Name
		driver.findElement(By.xpath("(//label[contains(text(),'Search this list')]/following::div/input)[1]")).sendKeys("karthikeyan",Keys.ENTER);
		Thread.sleep(3000);
		//Select first Result from search List
		driver.findElement(By.xpath("((//td[@role=\"gridcell\"])[1]/following::a)[1]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,\"slds-button_icon-border-filled\")])[6]/lightning-primitive-icon")).click();
		//Click Delete To delete the Selected Account
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@title=\"Delete\"]/span[text()='Delete']")).click();
		WebElement deletedAccInfo = driver.findElement(By.xpath("//span[contains(@class,\"toastMessage\")]"));
		System.out.println(deletedAccInfo.getText());
		System.out.println("DeleteAccount Eexcution Completed");
	}

}
