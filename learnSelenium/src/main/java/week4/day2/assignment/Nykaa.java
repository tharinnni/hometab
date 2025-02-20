package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		//Setup WebDriverManager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Launch Browser and URL
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		//Mousehover on Brands
		WebElement elementBrand = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(elementBrand).perform();

		//Click on BrandSearchbox
		WebElement elementBrandSearchBox = driver.findElement(By.xpath("//input[@id=\"brandSearchBox\"]"));
		elementBrandSearchBox.click();

		//Search by the productname and select
		elementBrandSearchBox.sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();

		//To filter based on Cutomer rating
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(3000);

		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//heck whether the Filter is applied with Shampoo
		List<WebElement> appliedFilter = driver.findElements(By.xpath("//span[text()='Filters Applied']/following::div[@class=\"css-1emjbq5\"]/span"));
		int count = 0;
		for (WebElement resultFilters : appliedFilter) {

			if (resultFilters.getText().equals("Shampoo") || resultFilters.getText().equals("Color Protection")) 
			{
				System.out.print(resultFilters.getText()+"   ");
				count ++;
				if(count>1) {
					System.out.println("Selected Filters are applied");
				}

			}
			else
			{
				System.out.println("Case Failed Please Some of The Filters are Missing");
				break;
			}
		}
		Thread.sleep(2000);
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class=\"css-d5z3ro\"]")).click();
		
		//Handle new window and switchto
		Set<String> switchWindow = driver.getWindowHandles();
		List<String> windowSwitch = new ArrayList<String>(switchWindow);
		driver.switchTo().window(windowSwitch.get(1));
		
		//Select size as 175ml
		WebElement dropDownML = driver.findElement(By.xpath("//select[@title=\"SIZE\"]"));
		Select selectML = new Select(dropDownML);
		selectML.selectByVisibleText("175ml");
		
		//Print the MRP of the product
		String mrpPrice = driver.findElement(By.xpath("(//span[text()='MRP:']/following::span)[1]")).getText();
		System.out.println("Price of the Product: "+mrpPrice);
		
		//Click on ADD to BAG and move to cart
		driver.findElement(By.xpath("(//button[@type=\"button\"]/following::span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class=\"cart-count\"]")).click();
		Thread.sleep(3000);
		
		//Switching to cart Frame
		driver.switchTo().frame(0);
		
		//Print Total in cart page
		String totalInCart = driver.findElement(By.xpath("(//span[text()='Grand Total']/following::div)[1]")).getText();
		String grandTotalInCard =totalInCart.replace("₹", "");
		System.out.println("Total Bill Amount in Cart: "+grandTotalInCard);
		
		//Click Proceed in cart page
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[contains(text(),'CONTINUE AS GUEST')]")).click();
		
		//To check grandtotal in checkout page
		String TotalCheckOut = driver.findElement(By.xpath("(//div[text()=\"Grand Total\"]/following::span)[1]")).getText();
		System.out.println("Total Bill Amount In CheckOut Page: "+TotalCheckOut);
		int toCheckOut = Integer.parseInt(grandTotalInCard);
		int toTotalCheckOut = Integer.parseInt(TotalCheckOut);
		
		//Verify the price same in both pages
		if(toCheckOut==toTotalCheckOut) {
			System.out.println("Both card and checkout page have the same GrandTotal");
		}else
		{
			System.out.println("Total Mistake in Card GrandTotal and Checkout GrandTotal");
		}
		
		//Close browser
		driver.quit();
	}

}
