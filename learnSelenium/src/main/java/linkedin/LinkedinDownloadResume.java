package linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkedinDownloadResume extends ProjectSpecifiedMethod{
	@Test(invocationCount = 2)
	public void downloadResume() {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Kannan Palanivel",Keys.ENTER);
		driver.findElement(By.xpath("(//span[@dir='ltr']/span)[1]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'artdeco-dropdown')]/following::span[text()='More'])[2]")).click();
		WebElement downloadResume = driver.findElement(By.xpath("(//span[text()='Save to PDF'])[2]"));
		downloadResume.click();
	}
}
