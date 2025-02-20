package week2.marathon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Setup WebDriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch Browser
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		/*
		 * //Input City Name and selecting movie
		 * driver.findElement(By.xpath("//input[@class=\"sc-jvEmr elijMA\"]")).sendKeys(
		 * "Chennai");
		 * driver.findElement(By.xpath("//span[@class=\"sc-fihHvN fUfZof\"]")).click();
		 * driver.findElement(By.id("4")).click();
		 * driver.findElement(By.xpath("//input[@class=\"sc-jvEmr elijMA\"]")).sendKeys(
		 * "vikram"); Thread.sleep(3000); driver.findElement(By.
		 * xpath("(//input[@class='sc-jvEmr elijMA']/following::strong)[1]")).click();
		 * //To print the theatorname
		 * driver.findElement(By.xpath("(//span[text()=\"Book tickets\"])[1]")).click();
		 * System.out.println(driver.findElement(By.xpath(
		 * "(//div[@class=\"listing-info\"])[1]//a[@class=\"__venue-name\"]")).getText()
		 * ); driver.findElement(By.xpath(
		 * "(//div[@class=\"listing-info\"])[1]//div[@class=\"info-section\"]")).click()
		 * ; Thread.sleep(3000); //To check availability of Parking Facility
		 * if(driver.findElement(By.xpath("//div[contains(text(),'Parking Facility')]"))
		 * .isDisplayed()) {
		 * System.out.println("Parking Facility Available in This Theater!!"); } else {
		 * System.out.println("Parking Facility Not Available in This Theater!!"); }
		 * //Booking sheet in available slots
		 * driver.findElement(By.xpath("//div[@class=\"cross-container\"]")).click();
		 * driver.findElement(By.
		 * xpath("(//div[@class=\"body showtimes-details-container \"])[1]//a")).click()
		 * ; driver.findElement(By.id("btnPopupAccept")).click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("(//ul[@id=\"popQty\"]//li)[1]")).click();
		 * driver.findElement(By.id("proceed-Qty")).click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath(
		 * "((//td[@class='SRow1'])[3]//div[@data-seat-type=\"1\"])[1]")).click();
		 * driver.findElement(By.id("btnSTotal_reserve")).click(); Thread.sleep(3000);
		 * //Print Subtotal of the booking
		 * System.out.println("Total Cost of This Booking: "+driver.findElement(By.xpath
		 * ("//span[@id=\"subTT\"]")).getText()); //Taking screenshot of the current
		 * page
		 */		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\My Works\\Eclipse Workspace\\learnSelenium\\src\\main\\java\\week2\\marathon\\Bookmyshow.jpg");
		FileUtils.copyFile(source,dest);
	}
	
}
