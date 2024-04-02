	package practice;
	
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import ObjectRepo.OrganizationInfoPage;
import ObjectRepo.OrganizationsPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
	
	public class Organization 
	{
		public static void main(String args[]) throws Throwable
		{

//			Create objects of all util class
			ExcelFileUtility eutil=new ExcelFileUtility();
			PropertyFileUtility putil=new PropertyFileUtility();
			SeleniumUtility sutil=new SeleniumUtility();
			
//			Launch browser
			WebDriver driver= new ChromeDriver();
			
//			Read data from property file
			String URL = putil.readDataFromProperty("url");
			String USERNAME=putil.readDataFromProperty("username");
			String PASSWORD=putil.readDataFromProperty("password");
			
//			Read data from excel file
			String ORGANIZATIONNAME=eutil.readNumericDataFromExcel("Organizations", 1, 2);
			
//			Maximize window
			sutil.maximizeWindow(driver);
			
//			Launch app
			driver.get(URL);

//			Login to app
			LoginPage login=new LoginPage(driver);
			login.loginToApp(USERNAME, PASSWORD);

//			Create Organization
			HomePage h=new HomePage(driver);
			h.goToOrganizations();
			
			OrganizationsPage op=new OrganizationsPage(driver);
			op.addOranizations();
			
			CreateNewOrganizationPage cno= new CreateNewOrganizationPage(driver);
			cno.createNewOrganizations(ORGANIZATIONNAME);
			
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String value=oip.fetchHeader();
			if(value.contains(ORGANIZATIONNAME))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL!!");
			}
			
//			 Logout of the app 
			h.logoutOfApp(driver);
			
//			close the browser 
			driver.quit();
		}
	}
