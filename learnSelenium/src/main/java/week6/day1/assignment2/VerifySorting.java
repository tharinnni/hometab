package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class VerifySorting extends SpecifiedMethod{
	@Test(groups = "Account")
	public void SalesForceVerifySorting() throws InterruptedException {
		System.out.println("VerifySorting Eexcution Started");
		driver.findElement(By.xpath("//p[text()=\"Sales\"]")).click();
		//Opening Accounts Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()=\"Accounts\"])[1]")));
		WebElement moveToAccounts = driver.findElement(By.xpath("(//span[text()=\"Accounts\"])[1]"));
		driver.executeScript("arguments[0].click()", moveToAccounts);
		//Sorting Name in Asc
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Account Name']")));
		WebElement sortInAsc = driver.findElement(By.xpath("//span[@title='Account Name']"));
		action.moveToElement(sortInAsc).perform();
		action.click().perform();
		System.out.println("VerifySorting Eexcution Competed");
	}

}
