package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepo.CreateNewContactPage;
import ObjectRepo.CreateNewLeadPage;
import ObjectRepo.HomePage;
import ObjectRepo.LeadInfoPage;
import ObjectRepo.LeadsPage;
import ObjectRepo.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Lead {

	public static void main(String[] args) throws Throwable 
	{
		
//		Create objects of all util class
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		SeleniumUtility sutil=new SeleniumUtility();
		
//		Launch browser
		WebDriver driver= new ChromeDriver();
		
//		Read data from property file
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = putil.readDataFromProperty("url");
		String USERNAME=putil.readDataFromProperty("username");
		String PASSWORD=putil.readDataFromProperty("password");
		
//		Read data from excel file
		String LASTNAME=eutil.readStringDataFromExcel("Lead", 1, 2);
		String COMPANY=eutil.readNumericDataFromExcel("Lead", 1, 3);
		
//		Maximize window
		sutil.maximizeWindow(driver);
		
//		Launch app
		driver.get(URL);

//		Login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
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
		System.out.println(value);
		
		if(value.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL!!");
		}
		
//		Logout of the app
		home.logoutOfApp(driver);
				
//		close the browser
		driver.quit();
		

	}

}
