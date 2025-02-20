package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DummyMainCaseforFailure extends SpecifiedMethod{

	@Test(dependsOnMethods = "week6.day1.assignment2.DummyPreconditionForFailureCase.dummyPreconditionMethod",groups = "Account")
	//Dummy Test Case
	public void dummyMainTestCase() {
		System.out.println("dummyMainTestCase Eexcution Started");
		WebElement moveToAccount  = driver.findElement(By.xpath("//p[text()='App Launcher']"));
		action.moveToElement(moveToAccount).perform();
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		System.out.println("dummyMainTestCase Eexcution completed");
	}

}
