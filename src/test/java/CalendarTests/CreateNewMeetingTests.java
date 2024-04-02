package CalendarTests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepo.CalendarPage;
import ObjectRepo.CreateNewMeetingPage;
import ObjectRepo.HomePage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplementation.class)

public class CreateNewMeetingTests extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void CreateMeeting() throws Throwable	
	{

//		Read data from excel file
		String EVENTNAME=eutil.readStringDataFromExcel("Calendar", 1, 2);
		String EVENTSTARTS1=eutil.readNumericDataFromExcel("Calendar", 1, 3);
		SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = inputFormat.parse(EVENTSTARTS1);
	    String EVENTSTARTS = outputFormat.format(date);
	    String EVENTENDS1=eutil.readNumericDataFromExcel("Calendar", 1, 4);
	    Date date1 = inputFormat.parse(EVENTENDS1);
	    String EVENTENDS = outputFormat.format(date1);
	    
//		Open Calendar Module
		HomePage home=new HomePage(driver);
		home.goToCalendar();
		
//		Add meeting
		CalendarPage c=new CalendarPage(driver);
		c.addMeeting();
		CreateNewMeetingPage m=new CreateNewMeetingPage(driver);
		m.addNewMeeting(EVENTNAME, EVENTSTARTS, EVENTENDS);
			
	}

}