package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class LeadInfoPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(className="dvHeaderText")
	private WebElement leadHeader;

//	Rule 3: Create a constructor for initilization
	public LeadInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getLeadHeader() {
		return leadHeader;
	}
	
	public String fetchHeader()
	{
		return leadHeader.getText();
	}
	
	
	
}
