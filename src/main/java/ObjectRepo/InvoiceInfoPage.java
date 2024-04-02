package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class InvoiceInfoPage 
{
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(className ="lvtHeaderText")
	private WebElement invoiceHeader;

//	Rule 3: Create a constructor for initilization
	public InvoiceInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getInvoiceHeader() {
		return invoiceHeader;
	}
	public String fetchHeader()
	{
		return invoiceHeader.getText();
	}
	
	
	
}
