package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement sourceDraggable = driver.findElement(By.id("draggable"));
		
		WebElement toDroppable = driver.findElement(By.id("droppable"));
		String beforeDrag = toDroppable.getText();
		System.out.println(beforeDrag);
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(sourceDraggable, toDroppable).perform();
		
		System.out.println(toDroppable.getText());
		
	}

}
