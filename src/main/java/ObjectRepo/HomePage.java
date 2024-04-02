package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

//Rule 1: Create a seperate POM class for every webpage
public class HomePage extends SeleniumUtility
{
	
//	Rule 2: Indentify the web Elements using @FindBy and make them private
	@FindBy(xpath="//a[text()=\"Calendar\"]")
	private WebElement calendarTab;
	@FindBy(xpath="//a[text()=\"Leads\"]")
	private WebElement leadsTab;
	@FindBy(xpath="//a[text()=\"Organizations\"]")
	private WebElement organizationsTab;
	@FindBy(xpath = "//a[text()=\"Contacts\"]")
	private WebElement contactsTab;
	@FindBy(xpath="//a[text()=\"Products\"]")
	private WebElement productTab;
	@FindBy(xpath="//a[text()=\"More\"]")
	private WebElement moreTab;
	@FindBy (xpath="//a[@name=\"Invoice\"]")
	private WebElement invoiceTab;
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImage;
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
//	Rule 3: Create a constructor for initilization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//	Rule 4: Provide getters
	public WebElement getCalendarTab() {
		return calendarTab;
	}

	public WebElement getLeadsTab() {
		return leadsTab;
	}

	public WebElement getOrganizationsTab() {
		return organizationsTab;
	}

	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getProductTab() {
		return productTab;
	}

	public WebElement getMoreTab() {
		return moreTab;
	}

	public WebElement getInvoiceTab() {
		return invoiceTab;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
//	Rule 5: Provide business library if required

/**
 * This method will go to Calendar Tab and click it.	
 */
	public void goToCalendar()
	{
		calendarTab.click();
	}

	/**
	 * This method will go to Leads Tab and click it.	
	 */
	public void goToLeads()
	{
		leadsTab.click();
	}

	/**
	 * This method will go to Organization Tab and click it.	
	 */
	public void goToOrganizations()
	{
		organizationsTab.click();
	}
	
	/**
	 * This method will go to Contacts Tab and click it.	
	 */
	public void goToContacts()
	{
		contactsTab.click();
	}
	
	/**
	 * This method will go to Products Tab and click it.	
	 */
	public void goToProducts()
	{
		productTab.click();
	}
	
	/**
	 * This method will go to Invoice Tab and click it.	
	 */
	public void goToInvoice(WebDriver driver)
	{
		moveToElementAction(driver, moreTab);
		moveToElementAction(driver, invoiceTab);
		invoiceTab.click();
	}
	
	/**
	 * This method will go to administrator image and logout of the app.	
	 */
	public void logoutOfApp(WebDriver driver)
	{
		moveToElementAction(driver ,adminImage);
		signOut.click();
	}
}
