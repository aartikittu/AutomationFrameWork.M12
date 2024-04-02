package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class CreateNewInvoicePage 
{

//	Rule 2: Indentify the web Elements using @FindBy and make them private	
	@FindBy(css="[name=\"subject\"]")
	private WebElement subjectTextBox;
	@FindBy(xpath="//input[@name=\"account_id\"]/following-sibling::img[@alt=\"Select\"]")
	private WebElement addOrganizationImg;
	@FindBy(name="bill_street")
	private WebElement billingAddressTextBox;
	@FindBy(name="ship_street")
	private WebElement shippingAddressTextBox;
	@FindBy(id="searchIcon1")
	private WebElement addItemImg;
	@FindBy (id="qty1")
	private WebElement qtyTextBox;
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
//	Rule 3: Create a constructor for initilization
	public CreateNewInvoicePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Rule 4: Provide getters
	public WebElement getSubjectTextBox() {
		return subjectTextBox;
	}

//	Rule 5: Provide business library if required
	public WebElement getAddOrganizationImg() {
		return addOrganizationImg;
	}


	public WebElement getBillingAddressTextBox() {
		return billingAddressTextBox;
	}


	public WebElement getShippingAddressTextBox() {
		return shippingAddressTextBox;
	}


	public WebElement getAddItemImg() {
		return addItemImg;
	}


	public WebElement getQty() {
		return qtyTextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
