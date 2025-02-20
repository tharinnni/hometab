package week2.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Declaring Variable for city
		String fromCity="Chennai",toCity="Bangalore";
		//Setup Driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive=new ChromeDriver();
		drive.manage().window().maximize();
		//Launch Browser
		drive.get("https://www.redbus.in/");
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Input From and To city
		drive.findElement(By.xpath("//input[@id=\"src\"]")).sendKeys(fromCity);
		drive.findElement(By.xpath("//i[contains(@class,'icon solr-icon')]/parent::li")).click();
		drive.findElement(By.xpath("//input[@id=\"dest\"]")).sendKeys(toCity);
		drive.findElement(By.xpath("//input[@id=\"dest\"]/following::li[@data-no=\"1\"]")).click();
		//Selecting tomorrow date
		drive.findElement(By.id("onward_cal")).click();
		drive.findElement(By.xpath("//td[text()='July 2022']/following::td[text()='22']")).click();
		//Search Available Bus
		drive.findElement(By.id("search_btn")).click();
		//To get and print available Bus
		System.out.println(drive.findElement(By.xpath("//span[@class=\"f-bold busFound\"]")).getText()+" In searched Route");
		//To Get the 2nd result from search list
		drive.findElement(By.xpath("//label[text()=\"SLEEPER\"]/preceding-sibling::label")).click();
		System.out.println("2nd Resulted Bus Name: "+drive.findElement(By.xpath("(//div[@id=\"result-section\"]//div[@class=\"travels lh-24 f-bold d-color\"])[2]")).getText());
		drive.findElement(By.xpath("(//div[@class=\"button view-seats fr\"])[2]")).click();	
		//Taking screenshot
		File source=drive.getScreenshotAs(OutputType.FILE);
		File dest=new File("Redbus.png");
		FileUtils.copyFile(source, dest);
		
	}
}
