package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtilities.ListenersImplementation.class)

public class TestNGPratice1 
{
	@Test(enabled=false)
	public void deleteContact()
	{
		System.out.println("Delete");
	}
	@Test(enabled=false)
	public void UpdateContact()
	{
		System.out.println("Update");
	}

	@Test
	public void createContact()
	{
		System.out.println("Create");
	}

}
