package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IRetryPtactice 	
{
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void letsRetry()
	{
		Assert.fail();
		System.out.println("HI");
	}
	
}
