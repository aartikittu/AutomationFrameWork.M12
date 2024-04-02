package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1: Create a seperate POM class for every webpage
public class LoginPage 
{
	
//	Rule 2: Identify the web Elements using @FindBy and make them private
	@FindBy(name="user_name")private WebElement userNameEdit;
	
	@FindBy(name="user_password")private WebElement passwordEdit;
	
	@FindBy(id="submitButton")private WebElement submitBtn;
	
//	Rule 3: Create a constructor for initilization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	Rule 4: Provide getters
	public WebElement getUserNameEdit() 
	{
		return userNameEdit;
	}

	public WebElement getPasswordEdit() 
	{
		return passwordEdit;
	}

	public WebElement getsubmitBtn() 
	{
		return submitBtn;
	}

//	Rule 5: Provide business library if required
	public void loginToApp(String username, String password)
	{
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitBtn.click();
	}
}
