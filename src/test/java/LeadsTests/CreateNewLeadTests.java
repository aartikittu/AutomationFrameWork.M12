package LeadsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadInfoPage;
import ObjectRepo.LeadsPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewLeadTests extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void CreateLead() throws Throwable 
	{
//		Read data from excel file
		String LASTNAME=eutil.readStringDataFromExcel("Lead", 1, 2);
		String COMPANY=eutil.readNumericDataFromExcel("Lead", 1, 3);

//		Create Lead
		HomePage home=new HomePage(driver);
		home.goToLeads();
		
		LeadsPage l=new LeadsPage(driver);
		l.addLead();
		
		CreateNewLeadPage c=new CreateNewLeadPage(driver);
		c.createNewLead(LASTNAME, COMPANY);

//		Validation
		LeadInfoPage l1=new LeadInfoPage(driver);
		String value= l1.fetchHeader();
		Assert.assertTrue(value.contains(LASTNAME));
		System.out.println(value);	
	}

}
