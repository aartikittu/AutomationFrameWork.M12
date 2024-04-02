package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class AddItemPage 
{

//	Rule 2: Indentify the web Elements using @FindBy and make them private	
	@FindBy(id="popup_product_23")
	private WebElement itemName;

//	Rule 3: Create a constructor for initilization
	public AddItemPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//	Rule 4: Provide getters
	public WebElement getItemName() {
		return itemName;
	}
	
//	Rule 5: Provide business library if required
	public void addItem()
	{
		itemName.click();
	}
}
