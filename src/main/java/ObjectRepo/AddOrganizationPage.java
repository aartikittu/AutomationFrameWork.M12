package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class AddOrganizationPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(linkText = "SpiderMan8")
	private WebElement orgName;

//	Rule 3: Create a constructor for initilization
	public AddOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getOrgName() {
		return orgName;
	}
	
//	Rule 5: Provide business library if required
	public void addOrganization()
	{
		orgName.click();
	}
}
