package week6.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase001 extends MarathonSpecifiedMethods{

	@BeforeTest
	private void chooseChromeBrowser() {
		browserName = "chrome";
		excelFileName = "Questions";

	}
	@Test(dataProvider = "smoke")
	public void testCaseSales(String questions,String details) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		Thread.sleep(3000);
		WebElement moveToChatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		//driver.executeScript("arguments[0].click()", moveToChatter);
		action.moveToElement(moveToChatter).click().perform();
		System.out.println("Title of the current page: "+driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[contains(@class,'cuf-questionTitleField')]")).sendKeys(questions);
		driver.findElement(By.xpath("(//span[text()='Details']/following::p)[1]")).sendKeys(details);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
	}
}
