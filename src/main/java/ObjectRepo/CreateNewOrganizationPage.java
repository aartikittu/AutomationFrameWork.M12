package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class CreateNewOrganizationPage 
{
	
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(css="[name=\"accountname\"]")
	private WebElement organizationNameTextBox;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
//	Rule 3: Create a constructor for initilization
	public CreateNewOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getOrganizationName() {
		return organizationNameTextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
//	Rule 5: Provide business library if required
	public void createNewOrganizations(String orgName)
	{
		organizationNameTextBox.sendKeys(orgName);
		saveButton.click();	
	}
	
	
	
}
