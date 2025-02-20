package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		//WebDriverManager Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch Browser		
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Link.html");
		//Get title of the currentpage
		String homePageTitle=driver.getTitle();
		//Moving to HomePage
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		//To check the link is active
		System.out.println(driver.findElement(By.xpath("(//div[@class=\"large-6 small-12 columns\"])[2]/a")).getAttribute("href"));
		driver.findElement(By.linkText("Verify am I broken?")).click();
		if(driver.findElement(By.xpath("//h1[text()='404 Not Found']")).getText().equals("404 Not Found")) {
			System.out.println("Page Not Found!!");
		}
		driver.navigate().back();
		//Check home page title from diffrent link
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		//Verify the title of home page from the both itration
		if(driver.getTitle().equals(homePageTitle))
		{
			System.out.println("Both are same links");
		}
		else
		{
			System.out.println("You are in wrong Page");
		}
		driver.close();
	}

}
