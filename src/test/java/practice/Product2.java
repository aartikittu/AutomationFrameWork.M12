package practice;

import org.testng.annotations.Test;

import ObjectRepo.ContactInfoPage;
import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.CreateNewProductPage;
import ObjectRepo.HomePage;
import ObjectRepo.ProductInfoPage;
import ObjectRepo.ProductsPage;
import genericUtilities.BaseClass;


public class Product2 extends BaseClass
{
	@Test(enabled=false)
	public void createProduct() throws Throwable
	{
		
//		Read data from excel file
		String PRODUCTNAME=eutil.readStringDataFromExcel("Product",1, 2);

//		Go to HomePage
		HomePage hp=new HomePage(driver);
		
//		Go to contacts
		hp.goToProducts();
		
//		Click on add Contact
		ProductsPage pp=new ProductsPage(driver);
		pp.addProduct();
		
//		Create new contact
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME);

//		Validate new contact created
		ProductInfoPage pip=new ProductInfoPage(driver);
		String value=pip.fetchHeader();
		if(value.contains(PRODUCTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL!!");
		}
	}
}
