package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\My Works\\Eclipse Workspace\\learnSelenium\\src\\test\\java\\features",
glue = "stefDef",
publish = true,
monochrome = true 
)
public class RunnerClass extends AbstractTestNGCucumberTests{

}
