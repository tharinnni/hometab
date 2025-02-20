package week6.day1.assignment2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DummyPreconditionForFailureCase extends SpecifiedMethod{
	
	@Test(groups = "Account")
	//Dummy Pre-Condition Method
	public void dummyPreconditionMethod() {
		System.out.println("dummyPreconditionMethod Eexcution Started");
		driver.findElement(By.linkText("a")).click();
		System.out.println("dummyPreconditionMethod Eexcution completed");
	}

}
