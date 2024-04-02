package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class OrganizationInfoPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(className ="dvHeaderText")
	private WebElement organizationHeader;

//	Rule 3: Create a constructor for initilization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getOrganizationHeader() {
		return organizationHeader;
	}
	
	public String fetchHeader()
	{
		return organizationHeader.getText();
		
	}
	
	
}
