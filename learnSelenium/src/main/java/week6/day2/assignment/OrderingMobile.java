package week6.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Shadow shadowDom = new Shadow(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev64810.service-now.com/navpage.do");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("310820@Atm");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(20000);
		WebElement elementAll = shadowDom.findElementByXPath("//div[text()='All']");
		elementAll.click();
		Thread.sleep(5000);
		WebElement webElementNavigater = shadowDom.findElementByXPath("//span[text()='Service Catalog']");
		webElementNavigater.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]"));
	}
}
