package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class OrganizationsPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(css="[alt=\"Create Organization...\"]")
	private WebElement createOrganizationsImg;

//	Rule 3: Create a constructor for initilization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getCreateOrganizationsImg() {
		return createOrganizationsImg;
	}
	
	public void addOranizations()
	{
		createOrganizationsImg.click();
	}
	
}
