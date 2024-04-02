
package ObjectRepo;

//Rule 1: Create a seperate POM class for every webpage
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(css="[alt=\"Create Lead...\"]")
	private WebElement createLeadImg;

//	Rule 3: Create a constructor for initilization
	public LeadsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}
	
	public void addLead()
	{
		createLeadImg.click();
	}
	
	
	
	
}
