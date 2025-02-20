package linkedin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ProjectSpecifiedMethod {
	ChromeDriver driver;
	@BeforeTest
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get("https://www.linkedin.com/home");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.id("username")).sendKeys("karthikyuva75@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Karthikarun@15");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

	}

}
