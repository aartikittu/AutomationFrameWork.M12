package ProductsTests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import ObjectRepo.CreateNewProductPage;
import ObjectRepo.HomePage;

import ObjectRepo.ProductInfoPage;
import ObjectRepo.ProductsPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewProductsTest extends BaseClass {

	@Test
	public void CreateProduct() throws Throwable
	{

//		Read data from excel file
		String PRODUCTNAME=eutil.readStringDataFromExcel("Product",1, 2);
				
//		Create product
		HomePage hp=new HomePage(driver);
		hp.goToProducts();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.addProduct();
		
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createNewProduct(PRODUCTNAME);

//		Validation
		ProductInfoPage pip=new ProductInfoPage(driver);
		String value=pip.fetchHeader();
		Assert.assertTrue(value.contains(PRODUCTNAME));
		System.out.println(PRODUCTNAME);
	}

}
