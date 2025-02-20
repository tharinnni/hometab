package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhonePrice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone",Keys.ENTER);
		List<WebElement> priceOfMobiles = driver.findElements(By.className("a-price-whole"));
		List<Integer> phonePrice = new ArrayList<Integer>();
		
		for (int i = 0; i < priceOfMobiles.size(); i++) {
			System.out.println(priceOfMobiles.get(i).getText());	
			String phoneArray = priceOfMobiles.get(i).getText().replace(",", "");
			int Price = Integer.parseInt(phoneArray);
			phonePrice.add(Price);
		}
		Collections.sort(phonePrice);
		System.out.println("Low price Mobile: "+phonePrice.get(0));
	}

}
