package OrganizationsTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationInfoPage;
import ObjectRepo.OrganizationsPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewOrganizationTests extends BaseClass{

	@Test
	public void CreateOrganization() throws Throwable
	{
//		Read data from excel file
		String ORGANIZATIONNAME=eutil.readNumericDataFromExcel("Organizations", 1, 2);
		ORGANIZATIONNAME=ORGANIZATIONNAME+Math.random();

//		Create Organization
		HomePage h=new HomePage(driver);
		h.goToOrganizations();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.addOranizations();
		
		CreateNewOrganizationPage cno= new CreateNewOrganizationPage(driver);
		cno.createNewOrganizations(ORGANIZATIONNAME);
		Thread.sleep(2000);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String value=oip.fetchHeader();
		Assert.assertTrue(value.contains(ORGANIZATIONNAME));
		System.out.println(ORGANIZATIONNAME);
	}

}
