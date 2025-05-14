package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners
public class BaseClass 
{
	public PropertyFileUtility putil= new PropertyFileUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	public WebDriver driver;
	
//	for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsconfig()
	{
		System.out.println("****DB connection successful****");
	}
	
	@BeforeClass(alwaysRun=true)
	public void bcconfig() throws Throwable
	{
		driver=new ChromeDriver();
		String URL=putil.readDataFromProperty("url");
		sutil.maximizeWindow(driver);

		driver.get(URL);
		
		sdriver=driver;

		System.out.println("****Launch Brower Successful****");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmconfig() throws Throwable
	{
		String USERNAME= putil.readDataFromProperty("username");
		String PASSWORD= putil.readDataFromProperty("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("****Login to app successful");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amconfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("****Logout from app successful****");
	}
	
	@AfterClass(alwaysRun=true)
	public void afconfig()
	{
		driver.quit();
		System.out.println("****Browser closure successful****");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asconfig()
	{
		System.out.println("****DB closure successful****");
	}
}
