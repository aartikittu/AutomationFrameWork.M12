package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPactice 
{
	@Test(enabled=false)
	public void sample()
	{
		SoftAssert sa=new SoftAssert();
		String a="hi";
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(1, 1); //PASS
		sa.assertEquals(1, 2); //FAIL
		sa.assertTrue(a.contains("i"));  //PASS
		sa.assertTrue(a.contains("m")); //FAIL
				
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll();
	}
}
