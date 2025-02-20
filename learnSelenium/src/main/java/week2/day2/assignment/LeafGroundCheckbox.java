package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckbox {

	public static void main(String[] args) {
		//WDM Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver drive=new ChromeDriver();
		//Launch Browser
		drive.manage().window().maximize();
		drive.get("http://www.leafground.com/pages/checkbox.html");
		//Checking Checkbox
		drive.findElement(By.xpath("//label[text()=\"Select the languages that you know?\"]/following-sibling::input[1]")).click();
		drive.findElement(By.xpath("//label[text()=\"Select the languages that you know?\"]/following-sibling::input[3]")).click();
		//To verify the check box selected by default
		boolean isChecked = drive.findElement(By.xpath("//label[text()=\"Confirm Selenium is checked\"]//following-sibling::input")).isSelected();
		if(isChecked) {
			System.out.println("Check box is Checked!!");
		}else
		{
			System.out.println("Check Box not Checked!!");
		}
		//select all the checkbox
		drive.findElement(By.xpath("(//label[text()=\"DeSelect only checked\"]//following-sibling::input)[2]")).click();
		
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[1]")).click();
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[2]")).click();
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[3]")).click();
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[4]")).click();
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[5]")).click();
//		drive.findElement(By.xpath("(//label[text()=\"Select all below checkboxes \"]/following-sibling::input)[6]")).click();
		
		List<WebElement> checkboxes = drive.findElements(By.xpath("//label[text()=\"Select all below checkboxes \"]/following-sibling::input"));
		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
			
		 
	}

}
