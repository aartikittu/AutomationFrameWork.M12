package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class ContactsPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(css="[alt=\"Create Contact...\"]")
	private WebElement createContactImg;

//	Rule 3: Create a constructor for initilization
	public ContactsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
//	Rule 5: Provide business library if required
	public void addContact()
	{
		createContactImg.click();
	}
	
	
	
	
}
