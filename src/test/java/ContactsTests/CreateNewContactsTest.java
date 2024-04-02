package ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.ContactInfoPage;
import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.HomePage;
import genericUtilities.BaseClass;


@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewContactsTest extends BaseClass{
	
	@Test
	public void CreateContact() throws Throwable
	{
		
//		Read data from excel file
		String LASTNAME=eutil.readStringDataFromExcel("Contacts", 1, 2);
		
//		Create contact
		HomePage hp= new HomePage(driver);
		hp.goToContacts();
		ContactsPage cp=new ContactsPage(driver);
		cp.addContact();
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME);
		
//		Validation
		ContactInfoPage cip=new ContactInfoPage(driver);
		String value=cip.getHeader();
		Assert.assertTrue(value.contains(LASTNAME));
		System.out.println(value);
		
	}

}
