package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertPactice 
{
	
	public void sample()
	{
		String a="hi";
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
//		Assert.assertEquals(1,1);	PASS
//		Assert.assertEquals(1,2);	FAIL
//		Assert.assertTrue(a.cotains("i");	PASS		
		Assert.assertTrue(a.contains("m"));
				
		System.out.println("Step 4");
		System.out.println("Step 5");
	}
}
