package week7.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewIncident extends SalesForceSpecifiedMethod{
	
	@Test
	public void createNewIncident() throws InterruptedException {

		//3. Click All
		shadow.findElementByXPath("//div[text()='All']").click();
		
		//4.Click  Incidents in Filter navigator
		Thread.sleep(3000);
		WebElement elementIncident = shadow.findElementByXPath("//span[text()='Incidents']");
		//action.moveToElement(elementIncident).click();
		elementIncident.click();
		
		//5. Click on Create new option and fill the mandatory fields
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Inident NUmber"+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		//6. Verify the newly created incident by getting the incident number and put it in search field and 
		//   enter then verify the instance number created or not

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
		
		//// Confirm incident exists !
		driver.switchTo().frame(eleFrame);
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 
	}
}