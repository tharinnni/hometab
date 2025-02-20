package week2.day2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookSignup {
	public static void main(String[] args) {
		//Setup WebDriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Creating Implicite Wait to wait incase if the browser taking time to load a page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Launch & Handle browser window
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		//To Input values in Input areas
		driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Kabir");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Ramz");
		driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys("9791920077");
		driver.findElement(By.xpath("//input[@name=\"reg_passwd__\"]")).sendKeys("Arohara");
		//Inputing Values in DOB
		WebElement selectDate = driver.findElement(By.xpath("//select[@name=\"birthday_day\"]"));
		Select dateDOB = new Select(selectDate);
		dateDOB.selectByVisibleText("14");
		WebElement selectMonth = driver.findElement(By.xpath("//select[@id=\"month\"]"));
		Select monthDOB=new Select(selectMonth);
		monthDOB.selectByIndex(4);
		WebElement selectYear = driver.findElement(By.id("year"));
		Select yearDOB=new Select(selectYear);
		yearDOB.selectByValue("1991");
		//To Selecting Male in Gender
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
	}

}
