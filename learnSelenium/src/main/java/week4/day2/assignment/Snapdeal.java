package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Setup WebDriverManager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions mouseAction = new Actions(driver);

		//Launch browser and load URL
		driver.get("https://www.snapdeal.com/");

		//Go to Mens Fashion
		WebElement menFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		mouseAction.moveToElement(menFashion).perform();

		//Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()=\"Sports Shoes\"])[1]")).click();

		//Get the count of the sports shoes
		String totalSportShoes = driver.findElement(By.xpath("//span[@class=\"category-name category-count\"]")).getText();
		System.out.println("Total Sport Shoes Present: "+totalSportShoes.replace("(", "").replace(")", ""));

		//Click Training shoes
		driver.findElement(By.xpath("//div[text()=\"Training Shoes\"]")).click();

		//Sort by Low to High
		driver.findElement(By.xpath("//div[@class=\"sort-selected\"]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Popularity')]/following::li)[2]")).click();
		Thread.sleep(2000);

		//Check if the items displayed are sorted correctly
		List<WebElement> checkPriceOrder = driver.findElements(By.xpath("//SPAN[@CLASS=\"lfloat product-price\"]"));
		for (int i = 0; i < checkPriceOrder.size()-1; i++) {
			String firstPrice = checkPriceOrder.get(i).getAttribute("data-price");
			String nextPrice = checkPriceOrder.get(i+1).getAttribute("data-price");
			int priceFirst = Integer.parseInt(firstPrice);
			int PriceNext = Integer.parseInt(nextPrice);
			if (priceFirst <= PriceNext) {

			}else {

				System.out.println("Filter lower to higher failed.. Check Screenshot for referance..!");
				WebElement moveTo = driver.findElement(By.xpath("//span[text()='Yes']"));
				mouseAction.scrollToElement(moveTo).perform();
				File source=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("Snapdeal.png");
				FileUtils.copyFile(source, dest);
				break; 

			}
		}

		//Select the price range
		WebElement fromValue = driver.findElement(By.xpath("//input[@name=\"fromVal\"]"));
		fromValue.clear();
		fromValue.sendKeys("500");
		WebElement toValue = driver.findElement(By.xpath("//input[@name=\"toVal\"]"));
		toValue.clear();
		toValue.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);

		//Filter with color Navy 
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label[1]")).click();

		//verify the all applied filters
		List<WebElement> enabledFilters = driver.findElements(By.xpath("//div[@class=\"filters\"]//div"));
		System.out.println("Enabled Filters are:  ");
		for (WebElement webElement : enabledFilters) {
			System.out.println(webElement.getText() + "  ");
		}

		//Mouse Hover on first resulting Training shoes
		WebElement firstProductFromResult = driver.findElement(By.xpath("(//a[@class=\"dp-widget-link hashAdded\"])[1]"));
		mouseAction.moveToElement(firstProductFromResult).perform();

		//lick QuickView button
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		Thread.sleep(2000);

		//Print the cost and the discount percentage
		String priceOfShoe = driver.findElement(By.xpath("//span[@class=\"payBlkBig\"]")).getText();
		String discountOfShoe = driver.findElement(By.xpath("//span[contains(@class,\"percent-desc\")]")).getText();
		System.out.println("Cost of the Selected Product is: "+priceOfShoe+" with discount of: "+discountOfShoe);

		//Take the snapshot of the shoes.
		File source1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File("Snapdealfinal.png");
		FileUtils.copyFile(source1, dest1);

		//Close the current window
		driver.close();
	}

}
