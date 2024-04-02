package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepo.LoginPage;
import genericUtilities.PropertyFileUtility;

public class VtigerCheckAll {

	public static void main(String[] args) throws Throwable 
	{
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		String URL = putil.readDataFromProperty("url");
		String USERNAME=putil.readDataFromProperty("username");
		String PASSWORD=putil.readDataFromProperty("password");
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]")).click();
	}

}
