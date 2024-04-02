package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

//Rule 1: Create a seperate POM class for every webpage
public class CreateNewContactPage extends SeleniumUtility
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(name="lastname")
	private WebElement lastNameTextBox;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	//	Rule 3: Create a constructor for initilization	
	public CreateNewContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
//	Rule 5: Provide business library if required
	public void createNewContact(String lastName)
	{
		lastNameTextBox.sendKeys(lastName);
		saveButton.click();
	}
	public void createNewContact(String lastName, String leadSourceValue)
	{
		lastNameTextBox.sendKeys(lastName);
		handleDropDown(lastNameTextBox, leadSourceValue);
		saveButton.click();
	}
	
}
