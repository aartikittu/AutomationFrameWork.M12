package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepo.CalendarPage;
import ObjectRepo.CreateNewMeetingPage;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Calendar 
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
		String EVENTNAME=eutil.readStringDataFromExcel("Calendar", 1, 2);
		String EVENTSTARTS=eutil.readStringDataFromExcel("Calendar", 1, 3);
		String EVENTENDS=eutil.readStringDataFromExcel("Calendar", 1, 4);
		
//		Maximize window
		sutil.maximizeWindow(driver);
		
//		Launch app
		driver.get(URL);

//		Login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

//		Open Calendar Module
		HomePage home=new HomePage(driver);
		home.goToCalendar();

//		Add meeting
		CalendarPage c=new CalendarPage(driver);
		c.addMeeting();
		CreateNewMeetingPage m=new CreateNewMeetingPage(driver);
		m.addNewMeeting(EVENTNAME, EVENTSTARTS, EVENTENDS);
			
//		Logout of the app
		home.logoutOfApp(driver);
		
//		close the browser
		driver.quit();
				
	}
}
