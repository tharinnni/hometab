package stefDef;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LaunchGoogle {
	
	public static ChromeDriver driver;
	
	@Given ("launch google chrome")
	public void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@And ("open google search engine")
	public void openGoogle() {
		driver.get("https://www.google.com/");
	}
	
	@And ("in searchbox type (.*)$")
	public void typeSearch(String data) {
		driver.findElement(By.xpath("(//img[@class='lnXdpd']/following::input)[1]")).sendKeys(data);
	}
	@And ("click on search button")
	public void clickOK() {
		driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
		Actions ac = new Actions(driver);
		ac.scrollToElement(null).perform();
		driver.switchTo().alert().accept();
		
	}
	@Then ("verify the results")
	public void verifyResult() {
		
	}

}



