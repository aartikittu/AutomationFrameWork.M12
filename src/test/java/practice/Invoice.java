package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepo.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Invoice 
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
		String PASSWORD=putil.readDataFromProperty("username");
		
//		Read data from excel file
		String SUBJECT=eutil.readStringDataFromExcel("Invoice", 1, 2);
				
		String BILLINGADDRESS=eutil.readStringDataFromExcel("Invoice", 1, 3);
		String SHIPPINGADDRESS=eutil.readStringDataFromExcel("Invoice", 1, 4);
		String ITEMNAME=eutil.readStringDataFromExcel("Invoice", 1, 5);
		String QTY=eutil.readNumericDataFromExcel("Invoice", 1, 6);

//		Maximize window
		sutil.maximizeWindow(driver);
		
//		Launch app
		driver.get(URL);

//		Login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

		
//		Create Invoice
		WebElement more=driver.findElement(By.xpath("//a[text()=\"More\"]"));
		sutil.moveToElementAction(driver, more);
		WebElement invoice=driver.findElement(By.name("Invoice"));
		sutil.moveToElementAction(driver, invoice);
		sutil.clickAction(invoice, driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt=\"Create Invoice...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys(SUBJECT);
		String mainId = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@alt=\"Select\"])[3]")).click();
		
		Set<String> Ids = driver.getWindowHandles();
		
		for(String id:Ids)
		{
			if(!mainId.equals(id))
			{
				driver.switchTo().window(id);
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[text()=\"Qspider\"]")).click();
		sutil.acceptAlert(driver);
		driver.switchTo().window(mainId);
		driver.findElement(By.xpath("//*[@name=\"bill_street\"]")).sendKeys(BILLINGADDRESS);
		driver.findElement(By.xpath("//*[@name=\"ship_street\"]")).sendKeys(SHIPPINGADDRESS);
		driver.findElement(By.id("productName1")).sendKeys(ITEMNAME);
		driver.findElement(By.id("searchIcon1")).click();
		Set<String> Ids2 = driver.getWindowHandles();
		for(String id2:Ids2)
		{	
			if(!mainId.equals(id2))
			{
				driver.switchTo().window(id2);
				break;
			}
		}
		driver.findElement(By.id("popup_product_6")).click();
		driver.switchTo().window(mainId);
		driver.findElement(By.id("qty1")).sendKeys(QTY);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click(); 

		String value=driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
		System.out.println(value);
		
		if(value.contains(SUBJECT))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL!!");
		}
		
		// Logout of the app 
		WebElement logout =driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sutil.moveToElementAction(driver, logout);
		driver.findElement(By.linkText("Sign Out")).click();
		  
//		close the browser 
		driver.quit();
		 
				
	
	
	}
}	
