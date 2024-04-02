package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepo.LoginPage;
import genericUtilities.PropertyFileUtility;

public class VtigerContactsPrint {

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
		List<WebElement> value = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[4]"));
		for(WebElement lastName:value)
		{
			System.out.println(lastName.getText());
		}
	}

}
