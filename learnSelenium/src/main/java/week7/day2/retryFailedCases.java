package week7.day2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryFailedCases implements IRetryAnalyzer{
	int maxTry = 0;
	public boolean retry(ITestResult result) {
		if(maxTry<1) {
			maxTry++;
			return true;
		}

		return false;
	}
}