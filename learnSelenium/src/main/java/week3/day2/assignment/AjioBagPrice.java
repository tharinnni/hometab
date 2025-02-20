package week3.day2.assignment;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioBagPrice {

	public static void main(String[] args) throws InterruptedException {
		//Declaration List
		Set<String> brandName = new LinkedHashSet<String>();
		//Setup Webdriver manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch chrome browser
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//To search bags 
		driver.findElement(By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]")).sendKeys("bags",Keys.ENTER);
		//To filter the results for men
		driver.findElement(By.xpath("//span[text()=\"gender\"]/following::label[contains(text(),\"Men\")]")).click();
		Thread.sleep(6000);
		//To filter the men fashion bags
		driver.findElement(By.xpath("//label[@for=\"Men - Fashion Bags\"]")).click();
		//To get and print number of available items print
		String itemFounds = driver.findElement(By.xpath("//div[@class=\"length\"]")).getText();
		System.out.println(itemFounds);
		//To get multiple elements of bag brand
		List<WebElement> bagBrands = driver.findElements(By.xpath("//div[@class=\"brand\"]"));
		//itrate list to remove duplicate name is brand name 
		for (int i = 0; i < bagBrands.size(); i++) {
			brandName.add(bagBrands.get(i).getText());
		}
		//Print brand names
		for(String s : brandName)
		{
			System.out.println(s);
		}
		//To get all the bag name from the result
		List<WebElement> bagName = driver.findElements(By.xpath("//div[@class=\"nameCls\"]"));
		for (int i = 0; i < bagName.size(); i++) {
			System.out.println(bagName.get(i).getText());
		}
	}

}
