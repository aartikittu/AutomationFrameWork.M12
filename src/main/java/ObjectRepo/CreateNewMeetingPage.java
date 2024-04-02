package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class CreateNewMeetingPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(name="subject")
	private WebElement eventNameTextBox;
	@FindBy(name="date_start")
	private WebElement eventStartTextBox;
	@FindBy(name="due_date")
	private WebElement eventEndTextBox;
	@FindBy(css="[alt=\"Save [Alt+S]\"]")
	private WebElement saveButton;

//	Rule 3: Create a constructor for initilization
	public CreateNewMeetingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//	Rule 4: Provide getters
	public WebElement getEventNameTextBox() {
		return eventNameTextBox;
	}
	public WebElement getEventStartTextBox() {
		return eventStartTextBox;
	}
	public WebElement getEventEndTextBox() {
		return eventEndTextBox;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void addNewMeeting(String eventName,String eventStartdate, String eventEndDate) throws Throwable
	{
		
		eventNameTextBox.sendKeys(eventName);
		eventStartTextBox.clear();
		eventStartTextBox.sendKeys(eventStartdate);
		/*
		 * Thread.sleep(3000); eventEndTextBox.clear(); Thread.sleep(3000);
		 * eventEndTextBox.sendKeys(eventEndDate);
		 */
		saveButton.click();
	}
	
}
