package week2.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"])[3]")).click();
		String resultCommon = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span")).getText();
		String[] totalCountResult=resultCommon.split(" ");
		System.out.println("Number of Result: "+totalCountResult[3]);
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//span[contains(text(),'Brand')]/following::i[@class=\"a-icon a-icon-checkbox\"])[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//span[contains(text(),'Brand')]/following::i[@class=\"a-icon a-icon-checkbox\"])[2]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[1]")).getText();
		//System.out.println("Result after Filter: "+resultFilter[3]);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Featured']/following::a[text()[normalize-space()='Newest Arrivals']]")).click();
		/*
		 * driver.findElement(By.xpath("//span[@class=\"a-dropdown-label\"]")).click();
		 * Select sortByFilter=new Select(sortBy);
		 * sortByFilter.selectByVisibleText("Newest Arrivals");
		 */
	}
}
