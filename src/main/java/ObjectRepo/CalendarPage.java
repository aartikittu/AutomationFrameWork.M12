package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class CalendarPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(className="calAddButton")
	private WebElement addDropDown;
	@FindBy(id="addmeeting")
	private WebElement meetingTab;

//	Rule 3: Create a constructor for initilization
	public CalendarPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getAddDropDown() {
		return addDropDown;
	}

	public WebElement getMeetingTab() {
		return meetingTab;
	}
	
//	Rule 5: Provide business library if required
	public void addMeeting()
	{
		addDropDown.click();
		meetingTab.click();
	}
	
	
	
	
}
