package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayGroundWindow {

	public static void main(String[] args) throws InterruptedException {
		//Setup Webdriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch Browser
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		//Creating set to handle new pages 
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> openPage = new ArrayList<String>(windowHandles);
		String newOpenPage = openPage.get(1);
		driver.switchTo().window(newOpenPage);
		driver.close();
		String toHome = openPage.get(0);
		driver.switchTo().window(toHome);
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()=\"Open Multiple Windows\"]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> countWindow = new ArrayList<String>(windowHandles2);
		//Printing number of active session
		System.out.println("Current Active Taps: "+countWindow.size());
		String thirdWindow = countWindow.get(2);
		driver.switchTo().window(thirdWindow);
		driver.close();
		String secondWindow = countWindow.get(1);
		driver.switchTo().window(secondWindow);
		driver.close();
		String mainWindow = countWindow.get(0);
		driver.switchTo().window(mainWindow);
		//Close all except this window
		driver.findElement(By.id("color")).click();
		//Set for handle browser page
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> countWindow1 = new ArrayList<String>(windowHandles3);
		//Closing other taps
		String thirdWindow1 = countWindow1.get(2);
		driver.switchTo().window(thirdWindow1);
		driver.close();
		String secondWindow1 = countWindow1.get(1);
		driver.switchTo().window(secondWindow1);
		driver.close();
		String mainWindow1 = countWindow.get(0);
		driver.switchTo().window(mainWindow1);
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()=\"Wait for 5 seconds\"]")).click();
		Thread.sleep(5000);
		//Close all current active browser tap
		driver.quit();
	}

}
