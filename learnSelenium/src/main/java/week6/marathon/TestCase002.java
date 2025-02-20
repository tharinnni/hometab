package week6.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase002 extends MarathonSpecifiedMethods{

	@BeforeTest
	private void chooseEdgeBrowser() {
		browserName = "edge";
		excelFileName = "Individual";

	}

	@Test(dataProvider = "smoke")
	public void individualTC002(String lastName) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Individuals");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mark[text()='Individuals']")));
		driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[@placeholder=\"Last Name\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'tooltip-trigger')]/following::div[@class=\"slds-icon-waffle\"]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'tooltip-trigger')]/following::div[@class=\"slds-icon-waffle\"]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Customers");
		driver.findElement(By.xpath("//mark[text()='Customers']")).click();
		driver.findElement(By.xpath("(//div[text()='New' and @title=\"New\"])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Name']/following::input)[4]")).sendKeys(lastName);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}
}
