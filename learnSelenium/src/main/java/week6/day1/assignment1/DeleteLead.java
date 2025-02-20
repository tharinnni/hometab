package week6.day1.assignment1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends ProjectSpecifiedMethods{
	@Test(priority = 1)
	public void leafTapDeleteLead() throws InterruptedException {
		//Move to Delete Page
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("((//label[text()=\"First name:\"])[3]/following::input)[1]")).sendKeys("karthikeyan");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("((//label[text()='Phone Number:'])[4]/following::input)[3]")).sendKeys("9791920077");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(600);
		//To checks the data present in the table
		String checkTableData = driver.findElement(By.className("x-paging-info")).getText();
		if(checkTableData.equals("No records to display")) 
		{
			System.out.println("Data Not Present Here, Please Search Again..!");
		}else//Deleting the first data from the search result.
		{
			driver.findElement(By.xpath("((//div[@class='x-grid3-cell-inner x-grid3-col-formatedPrimaryPhone'])[1]/preceding::a[@class='linktext'])[4]")).click();
			driver.findElement(By.className("subMenuButtonDangerous")).click();
			System.out.println("Data Deleted Successfully!!");
		}
	}

}
