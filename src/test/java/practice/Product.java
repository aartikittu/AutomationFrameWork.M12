package practice;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepo.ContactInfoPage;
import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContactPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Product 
{
	public static void main(String args[]) throws Throwable
	{
		
//		Create objects of all util class
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		SeleniumUtility sutil=new SeleniumUtility();

//		Launch browser
		WebDriver driver= new ChromeDriver();
		
//		Read data from property file
		String URL =putil.readDataFromProperty("url");
		String USERNAME=putil.readDataFromProperty("username");
		String PASSWORD=putil.readDataFromProperty("username");
		
//		Read data from excel file
		String PRODUCTNAME=eutil.readStringDataFromExcel("Product",1, 2);
				
//		Maximize window
		sutil.maximizeWindow(driver);
		
//		Launch app
		driver.get(URL);

//		Login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
//		Create product
		HomePage hp=new HomePage(driver);
		hp.goToContacts();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.addContact();
		
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.createNewContact(PRODUCTNAME);

		ContactInfoPage cip=new ContactInfoPage(driver);
		String value=cip.getHeader();
		if(value.contains(PRODUCTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL!!");
		}
		
//		Logout of the app
		hp.logoutOfApp(driver);
		
//		close the browser
		driver.quit();

	}
}
