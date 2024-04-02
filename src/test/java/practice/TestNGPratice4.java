package practice;

import org.testng.annotations.Test;

public class TestNGPratice4 
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

	@Test(enabled=false)
	public void createContact()
	{
		System.out.println("Create");
	}
}
