package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage 
{
	@FindBy(xpath="//img[@title=\"Create Invoice...\"]")
	private WebElement createInvoiceImg;

	public InvoicePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateInvoiceImg() {
		return createInvoiceImg;
	}
	
	public void addInvoice()
	{
		createInvoiceImg.click();
	}
	
}
