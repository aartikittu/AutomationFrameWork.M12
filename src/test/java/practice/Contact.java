package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepo.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Contact 
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
		String URL = putil.readDataFromProperty("url");
		String USERNAME=putil.readDataFromProperty("username");
		String PASSWORD=putil.readDataFromProperty("password");
		
//		Read data from excel file
		String LASTNAME=eutil.readStringDataFromExcel("Contacts", 1, 2);

//		Maximize window
		sutil.maximizeWindow(driver);
		
//		Launch app
		driver.get(URL);

//		Login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
//		Create contact
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		String mainId = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		
//		Validation
		String value=driver.findElement(By.className("dvHeaderText")).getText();
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
		WebElement logout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sutil.moveToElementAction(driver, logout);
		driver.findElement(By.linkText("Sign Out")).click();
				
//		close the browser
		driver.quit();
				
	
	
	}
}
