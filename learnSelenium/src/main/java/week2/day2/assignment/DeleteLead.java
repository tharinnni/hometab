package week2.day2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		//Setup WebDriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Launch & Handle browser window
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Logging in into Application
		driver.findElement(By.name("USERNAME")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//Navigating to Lead Page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Finding Existing Lead by FirstName
		driver.findElement(By.linkText("Leads")).click();
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
		//Closing the Webbrowser.
		driver.close();
	}

}
