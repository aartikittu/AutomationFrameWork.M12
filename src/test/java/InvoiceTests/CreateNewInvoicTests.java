package InvoiceTests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.AddItemPage;
import ObjectRepo.AddOrganizationPage;
import ObjectRepo.CreateNewInvoicePage;
import ObjectRepo.HomePage;
import ObjectRepo.InvoiceInfoPage;
import ObjectRepo.InvoicePage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewInvoicTests extends BaseClass {

	@Test
	public void CreateInvoice() throws Throwable
	{		
//		Read data from excel file
		String SUBJECT=eutil.readStringDataFromExcel("Invoice", 1, 2);
		String BILLINGADDRESS=eutil.readStringDataFromExcel("Invoice", 1, 3);
		String SHIPPINGADDRESS=eutil.readStringDataFromExcel("Invoice", 1, 4);
		String ITEMNAME=eutil.readStringDataFromExcel("Invoice", 1, 5);
		String QTY=eutil.readNumericDataFromExcel("Invoice", 1, 6);
		
//		Create Invoice
		HomePage hp=new HomePage(driver);
		hp.goToInvoice(driver);
		InvoicePage ip=new InvoicePage(driver);
		ip.addInvoice();
		CreateNewInvoicePage cni=new CreateNewInvoicePage(driver);
		cni.getSubjectTextBox().sendKeys(SUBJECT);
		String mainId = driver.getWindowHandle();
		cni.getAddOrganizationImg().click();
		Set<String> Ids = driver.getWindowHandles();
		
		for(String id:Ids)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
				break;
			}
		}
		AddOrganizationPage ao=new AddOrganizationPage(driver);
		ao.addOrganization();
		sutil.acceptAlert(driver);
		driver.switchTo().window(mainId);
		cni.getBillingAddressTextBox().sendKeys(BILLINGADDRESS);
		cni.getShippingAddressTextBox().sendKeys(SHIPPINGADDRESS);
		cni.getAddItemImg().click();
		Set<String> Ids2 = driver.getWindowHandles();
		for(String id2:Ids2)
		{	
			if(!mainId.equals(id2))
			{
				driver.switchTo().window(id2);
				break;
			}
		}
		AddItemPage ai=new AddItemPage(driver);
		ai.addItem();
		driver.switchTo().window(mainId);
		cni.getQty().sendKeys(QTY);
		cni.getSaveButton().click();
		
//		Validation
		InvoiceInfoPage ii=new InvoiceInfoPage(driver);
		String value= ii.fetchHeader();
		Assert.assertTrue(value.contains(SUBJECT));
		System.out.println(value);
	}

}
