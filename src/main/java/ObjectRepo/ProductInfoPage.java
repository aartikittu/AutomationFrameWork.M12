package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class ProductInfoPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(className ="lvtHeaderText")
	private WebElement productHeader;

//	Rule 3: Create a constructor for initilization
	public ProductInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getProductHeader() {
		return productHeader;
	}
	
	public String fetchHeader()
	{
		return productHeader.getText();
	}
	
}
